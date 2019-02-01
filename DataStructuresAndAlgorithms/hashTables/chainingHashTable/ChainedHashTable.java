package hashTables.chainingHashTable;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashTable {

    private LinkedList<StoredEmployee>[] hashTable;

    public ChainedHashTable() {
        this.hashTable = new LinkedList[10];
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new LinkedList<>();
        }
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        hashTable[hashedKey].add(new StoredEmployee(key, employee));
    }

    public Employee get(String key) {
        int hashIndex = hashKey(key);
        int hashKey = findKey(hashIndex, key);
        if (hashKey == -1)
            return null;
        return hashTable[hashIndex].get(hashKey).getEmployee();
    }

    public Employee remove(String key) {
        int hashIndex = hashKey(key);
        int hashKey = findKey(hashIndex, key);
        if (hashKey == -1)
            return null;
        return hashTable[hashIndex].remove(hashKey).getEmployee();
    }

    public void printHashTable() {

        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i].isEmpty())
                System.out.println("Position " + (i + 1) + " is empty.");
            else {
                ListIterator<StoredEmployee> iterator
                        = hashTable[i].listIterator();
                while (iterator.hasNext()) {
                    System.out.print(iterator.next().getEmployee());
                    System.out.print(" -> ");
                }
                System.out.println("NULL");
            }
        }
    }

    private int findKey(int hashIndex, String hashKey) {
        ListIterator<StoredEmployee> iterator =
                hashTable[hashIndex].listIterator();
        int index = -1;
        while (iterator.hasNext()) {
            index++;
            if (iterator.next().getKey().equals(hashKey))
                return index;
        }

        return -1;
    }

    private int hashKey(String key) {
        return key.length() % hashTable.length;
    }

}
