package InputAndOutput;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {


        Path locPath = FileSystems.getDefault().getPath("locations.dat");

        try(ObjectOutputStream locFile= new ObjectOutputStream
                (new BufferedOutputStream(Files.newOutputStream(locPath)))) {
            for (Location location: locations.values()) {
                locFile.writeObject(location);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


//        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
//        Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");
//
//        try (BufferedWriter locFile = Files.newBufferedWriter(locPath);
//             BufferedWriter dirFile = Files.newBufferedWriter(dirPath)) {
//
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                for (String direction : location.getExits().keySet()) {
//                    if (!direction.equalsIgnoreCase("q")) {
//                        dirFile.write(location.getLocationID() + "," + direction + ","
//                                + location.getExits().get(direction) + "\n");
//                    }
//                }
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//

    }

    static {


        Path locPath = FileSystems.getDefault().getPath("locations.dat");
        try (ObjectInputStream locFile = new ObjectInputStream
                (new BufferedInputStream(Files.newInputStream(locPath)))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    locations.put(location.getLocationID(), location) ;
                } catch (EOFException e) {
                    eof = true ;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.getStackTrace();
        }


//        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
//        Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");
//
//        try (Scanner scanner = new Scanner(Files.newBufferedReader(locPath))) {
//            scanner.useDelimiter(",");
//            while (scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
//                System.out.println("Imported loc :" + loc + ": " + description);
//                locations.put(loc, new Location(loc, description, null));
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try (BufferedReader dirFile = Files.newBufferedReader(dirPath)) {
//
//            String input;
//
//            while ((input = dirFile.readLine()) != null) {
//                String line[] = input.split(",");
//                int loc = Integer.parseInt(line[0]);
//                String direction = line[1];
//                int destination = Integer.parseInt(line[2]);
//                System.out.println(String.format("%d : %s : %d", loc, direction, destination));
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//            }
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

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