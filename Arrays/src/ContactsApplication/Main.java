package ArrayListChallenge;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("82 47 484 098");

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {

            System.out.println("Enter option :( 6 _ to show the available options)\n");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
            case 0:
                System.out.println("Shutting down ... ");
                quit = true;
                break;
            case 1:
                mobilePhone.printContacts();
                break;
            case 2:
                addContact();
                break;
            case 3:
                removeContact();
                break;
            case 4:
                updateContact();
                break;
            case 5:
                queryContact();
                break;
            case 6:
                printActions();
                break;
            }
        }
    }

    private static void startPhone() {
        System.out.println("Starting phone ...");
    }

    private static void printActions() {
        System.out.println("Available actions:\n" + "press\n" + "0 - to shutdown\n" + "1- print contacts \n"
                + "2 - add a new contact\n" + "3 - remove the existing contact\n" + "4 - update an existing contact\n"
                + "5 - query for a contact\n" + "6 - print the list of available actions again \n"
                + "Choose your action - \n");
    }

    private static void addContact() {
        System.out.println("Enter new contact name :");
        String name = scanner.nextLine();
        System.out.println("Enter " + name + " 's phone number :");
        String number = scanner.nextLine();
        Contacts newContact = Contacts.createContact(name, number);
        if (mobilePhone.addContact(newContact)) {
            System.out.println("New contact added \n" + "Name : " + name + " \nNumber : " + number);
        } else {
            System.out.println("Cannot add " + name + " , already on file .");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing name : ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
        } else {
            System.out.println("Enter new contact name :");
            String contactName = scanner.nextLine();
            System.out.println("Enter " + contactName + " 's phone number :");
            String number = scanner.nextLine();
            Contacts newContact = Contacts.createContact(contactName, number ) ;
            if(mobilePhone.updateContact(existingContactRecord, newContact)) {
                System.out.println("Successfully updated records .");
            } else{
                System.out.println("Error updating record .");
            }

        }
    }

    private static void removeContact() {
        System.out.println("Enter existing name : ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
        } else {
            if(mobilePhone.removeContact(existingContactRecord)){
                System.out.println("Contact removed .");
            } else {
                System.out.println("error deleting contact .");
            }
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing name : ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
        } else {
           System.out.println("Name : " +existingContactRecord.getName()+ "\nNumber : "+existingContactRecord.getNumber());
        }
    }
}
