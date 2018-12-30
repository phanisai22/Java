package InputAndOutput;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {


        try (ObjectOutputStream locWriter = new ObjectOutputStream(new BufferedOutputStream
                (new FileOutputStream("locations_serialize.dat")))) {
            for (Location location : locations.values()) {
                locWriter.writeObject(location);
            }

        }


//
//        try (BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
//             BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))
//        ) {
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                for (String direction : location.getExits().keySet()) {
//                    if (!direction.equalsIgnoreCase("q")) {
//                        dirFile.write(location.getLocationID() + "," + direction + ","
//                                + location.getExits().get(direction) + "\n");
//                    }
//                }
//            }


//
//        try (DataOutputStream locFile = new DataOutputStream(
//                new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
//
//            for (Location location : locations.values()) {
//                locFile.writeInt(location.getLocationID());
//                locFile.writeUTF(location.getDescription());
//                System.out.println("Writing location " + location.getLocationID() +
//                        ": " + location.getDescription());
//                System.out.println("Writing " + (location.getExits().size() - 1) + " exits.");
//                locFile.writeInt(location.getExits().size() - 1);
//                for (String direction : location.getExits().keySet()) {
//                    if (!direction.equalsIgnoreCase("q")) {
//                        locFile.writeUTF(direction);
//                        locFile.writeInt(location.getExits().get(direction));
//                    }
//                }
//            }


//        FileWriter locFile = null;
//        try {
//            locFile = new FileWriter("locations.txt");
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                if (locFile != null) {
//                    System.out.println("Closing FileWriter ... ");
//                    locFile.close();
//                }
//            } catch (IOException e) {
//                System.out.println(e.getMessage());
//            }
//        }
    }


//    OBJECT RANDOM ACCESS FILE
//    1. This first four bytes will contain the number of locations (bytes 0-3 )
//    2. The next four bytes contains the start offset of the locations section (bytes 4-7)
//    3. The next section of the file will contain the index (The index is 1692 bytes long. (bytes 8-1699)
//    4. The final section of the file will contain the location records (The data) (bytes 1700 - )

    static {

        try (ObjectInputStream locReader = new ObjectInputStream(new BufferedInputStream
                (new FileInputStream("locations_serialize.dat")))) {

            boolean eof = false;
            while (!eof) {
                try {

                    Location location = (Location) locReader.readObject();
                    System.out.println("Reading location " + location.getLocationID() +
                            " : " + location.getDescription());
                    System.out.println("Found " + (location.getExits().size() - 1) + " exits.");
                    locations.put(location.getLocationID(), location);

                } catch (EOFException e) {
                    eof = true;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }


//        try (DataInputStream locReader = new DataInputStream(new BufferedInputStream
//                (new FileInputStream("locations.dat")))) {
//
//            boolean eof = false;
//            while (!eof) {
//                try {
//                    Map<String, Integer> exits = new LinkedHashMap<>();
//                    int locId = locReader.readInt();
//                    String description = locReader.readUTF();
//                    System.out.println("Reading location " + locId + " : " + description);
//                    int numExits = locReader.readInt();
//                    System.out.println("Found " + numExits + " exits.");
//
//                    for (int i = 0; i < numExits; i++) {
//                        String direction = locReader.readUTF();
//                        int destination = locReader.readInt();
//                        exits.put(direction, destination);
//                        System.out.println("\t\t" + direction + " : " + destination);
//                    }
//                    locations.put(locId, new Location(locId, description, exits));
//
//                } catch (EOFException e) {
//                    eof = true;
//                }
//            }
//
//        } catch (IOException | NullPointerException e) {
//            System.out.println(e.getMessage());
//        }


//        try (Scanner scanner = new Scanner(new FileReader("locations_big.txt"))) {
//
//            scanner.useDelimiter(",");
//
//            System.out.println("Importing Locations ...");
//            while (scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
////                System.out.println(loc + " : " + description);
//                Map<String, Integer> tempExits = new HashMap<>();
//                locations.put(loc, new Location(loc, description, tempExits));
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        }


//
//        try (BufferedReader locReader = new BufferedReader(new FileReader("locations_big.txt"))) {
//
//            String input;
//            System.out.println("Importing Locations ...");
//            while ((input = locReader.readLine()) != null) {
//                String[] line = input.split(",");
//                int loc = Integer.parseInt(line[0]);
//                String description = line[1];
////                System.out.println(loc + " : " + description);
//                Map<String, Integer> tempExits = new HashMap<>();
//                locations.put(loc, new Location(loc, description, tempExits));
//            }
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }


//        Now read the exits

//        try (BufferedReader dirReader = new BufferedReader(new FileReader("directions_big.txt"))) {
//            System.out.println("Importing Directions ... ");
//
//            String input;
//            while ((input = dirReader.readLine()) != null) {
////                int loc = scanner.nextInt();
////                scanner.skip(scanner.delimiter());
////                String direction = scanner.next();
////                scanner.skip(scanner.delimiter());
////                String dest = scanner.nextLine();
////                int destination = Integer.parseInt(dest);
//
//                String[] line = input.split(",");
//                int loc = Integer.parseInt(line[0]);
//                String direction = line[1];
//                int destination = Integer.parseInt(line[2]);
////                System.out.println(loc + " : " + direction+" : "+destination);
//                locations.get(loc).addExit(direction, destination);
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }


//        Map<String, Integer> tempExit;
//        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", null));
//
//        tempExit = new HashMap<>();
//        tempExit.put("W", 2);
//        tempExit.put("E", 3);
//        tempExit.put("S", 4);
//        tempExit.put("N", 5);
//        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExit));
//
//        tempExit = new HashMap<>();
//        tempExit.put("N", 5);
//        locations.put(2, new Location(2, "You are at the top of a hill", tempExit));
//
//        tempExit = new HashMap<>();
//        tempExit.put("W", 1);
//        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));
//
//        tempExit = new HashMap<>();
//        tempExit.put("N", 1);
//        tempExit.put("W", 2);
//        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));
//
//        tempExit = new HashMap<>();
//        tempExit.put("S", 1);
//        tempExit.put("W", 2);
//        locations.put(5, new Location(5, "You are in the forest", tempExit));

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
}