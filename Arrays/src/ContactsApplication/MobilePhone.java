package ContactsApplication;

import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Contacts> myContacts;
    private String myPhoneNumber;

    public MobilePhone(String myPhoneNumber) {
        this.myContacts = new ArrayList<Contacts>();
        this.myPhoneNumber = myPhoneNumber;
    }

    public boolean addContact(Contacts contact) {
        if (findContact(contact) >= 0) {
            System.out.println("Contact already exists .");
            return false;
        } else {
            myContacts.add(contact);
            return true;
        }
    }

    private int findContact(Contacts contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String name) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contacts contact = this.myContacts.get(i);
            if (contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact) {
        int position = findContact(oldContact);
        if (position < 0) {
            System.out.println(oldContact.getName() + " : " + oldContact.getNumber() + " is not found .");
            return false;
        } else {
            this.myContacts.set(position, newContact);
            System.out.println(oldContact.getName() + " is now replaced by new contact " + newContact.getName());
            return true;
        }
    }

    public String queryContact(Contacts contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public Contacts queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    public boolean removeContact(Contacts contact) {
        int position = findContact(contact);
        if (position < 0) {
            System.out.println(contact.getName() + " : " + contact.getNumber() + " is not found .");
            return false;
        } else {
            this.myContacts.remove(position);
            System.out.println(contact.getName() + " is now deleted .");
            return true;
        }
    }

    public void printContacts() {
        System.out.printf("Contact list of number : "+myPhoneNumber+"\n");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + " : " + myContacts.get(i).getName() + " ->> " + myContacts.get(i).getNumber());
        }
    }
}
