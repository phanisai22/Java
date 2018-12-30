package com.phanisai;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

    public static void main(String[] args) throws IOException {

//    OBJECT RANDOM ACCESS FILE
//    1. This first four bytes will contain the number of locations (bytes 0-3 )
//    2. The next four bytes contains the start offset of the locations section (bytes 4-7)
//    3. The next section of the file will contain the index (The index is 1692 bytes long. (bytes 8-1699)
//    4. The final section of the file will contain the location records (The data) (bytes 1700 - )

        try (RandomAccessFile rao = new RandomAccessFile("locations_random.dat", "rwd")) {

            rao.writeInt(locations.size());
            int indexSize = locations.size() * 3 * Integer.BYTES;
            int startLocation = (int) (indexSize + rao.getFilePointer() + Integer.BYTES);
            rao.writeInt(startLocation);

            long startIndex = rao.getFilePointer();

            int startPointer = startLocation;
            rao.seek(startIndex);

            for (Location location : locations.values()) {
                rao.writeInt(location.getLocationID());
                rao.writeUTF(location.getDescription());
                StringBuilder sb = new StringBuilder();
                for (String direction : location.getExits().keySet()) {
                    sb.append(direction);
                    sb.append(",");
                    sb.append(location.getExits().get(direction));
                    sb.append(",");
                }
                rao.writeUTF(sb.toString());

                IndexRecord record = new IndexRecord(startPointer, (int) rao.getFilePointer() - startLocation);
                index.put(location.getLocationID(), record);

                startPointer = (int) rao.getFilePointer();
            }

            rao.seek(startIndex);
            for (Integer locationId : index.keySet()) {
                rao.writeInt(locationId);
                rao.writeInt(index.get(locationId).getStartByte());
                rao.writeInt(index.get(locationId).getLength());
            }
        }
    }


    static {

        try {
            ra = new RandomAccessFile("locations_random.dat", "rwd");
            int numLocations = ra.readInt();
            long locationStartPoint = ra.readInt();

            while (ra.getFilePointer() < locationStartPoint) {
                int locationId = ra.readInt();
                int locationStart = ra.readInt();
                int locationLength = ra.readInt();

                IndexRecord record = new IndexRecord(locationStart, locationLength);
                index.put(locationId, record);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public Location getLocation(int locationId) throws IOException {

        IndexRecord record = index.get(locationId);
        ra.seek(record.getStartByte());
        int id = ra.readInt();
        String description = ra.readUTF();
        String exits = ra.readUTF();
        String[] exitPart = exits.split(",");

        Location location = new Location(locationId, description, null);

        if (locationId != 0) {
            for (int i = 0; i < exitPart.length; i++) {
                System.out.println("exitPart = " + exitPart[i]);
                System.out.println("exitPart[+1] = " + exitPart[i + 1]);
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction, destination);
            }
        }

        return location;
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }

    public void close() throws IOException {
        ra.close();
    }
}