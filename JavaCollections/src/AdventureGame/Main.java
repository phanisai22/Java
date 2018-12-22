package AdventureGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "you are sitting in front of a computer learning java"));
        locations.put(1, new Location(1, "you are standing at the end of the road before a brick building"));
        locations.put(2, new Location(2, "you are at the top of the hill"));
        locations.put(3, new Location(3, "you are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "you are in a valley beside a stream"));
        locations.put(5, new Location(5, "you are in a forest"));

        locations.get(1).addExit("WEST", 2);
        locations.get(1).addExit("EAST", 3);
        locations.get(1).addExit("NORTH", 5);
        locations.get(1).addExit("SOUTH", 4);

        locations.get(2).addExit("NORTH", 5);

        locations.get(3).addExit("WEST", 0);

        locations.get(4).addExit("NORTH", 1);
        locations.get(4).addExit("WEST", 2);

        locations.get(5).addExit("WEST", 2);
        locations.get(5).addExit("SOUTH", 1);

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exits - ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + " ,");
            }
            System.out.println();

            String[] direction = scanner.nextLine().toUpperCase().split(" ");

            int i;
            for (i = 0; i < direction.length; i++) {
                if (exits.containsKey(direction[i])) {
                    loc = exits.get(direction[i]);
                    break;
                }
            }
            if (i == direction.length) {
                System.out.println("You cannot go in that direction .");
            }

        }

    }
}
