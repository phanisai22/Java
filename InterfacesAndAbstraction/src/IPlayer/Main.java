package IPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Player player = new Player("player", 22, 23);
        System.out.println(player.toString());
        saveObject(player);

        player.setHitPoints(45);
        player.setWeapon("akm");
        saveObject(player);
        loadObject(player);
        System.out.println(player);

        ISaveable wareWolf = new Monster("Ware Wolf", 20, 100);
        saveObject(wareWolf);
        System.out.println(wareWolf);
        System.out.println(((Monster) wareWolf).getHealth());

    }

    private static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        System.out.println("Choose\n\t" +
                "0 - to quit\n\t" +
                "1 - to enter a string");
        while (!quit) {
            System.out.println("Choose an option : ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    quit = true;
                    break;

                case 1:
                    System.out.println("Enter the string : ");
                    String input = scanner.nextLine();
                    values.add(input);
            }
        }

        return values;
    }

    private static void saveObject(ISaveable objectToSave) {
        for (int i = 0; i < objectToSave.write().size(); i++) {
            System.out.println("saving " + objectToSave.write().get(i) + " to storage device .");
        }
    }

    private static void loadObject(ISaveable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }
}
