package hashTables.simpleHashTable;

public class SimpleHashTable {

    private StoredEmployee[] hashTable;

    public SimpleHashTable() {
        hashTable = new StoredEmployee[10];
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        if (occupied(hashedKey)) {
            int stopIndex = hashedKey;

            if (hashedKey == hashTable.length - 1)
                hashedKey = 0;
            else
                hashedKey++;

            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashTable.length;
            }
        }

        if (occupied(hashedKey)) {
            System.out.println("The position already taken " + hashedKey);
            return;
        }

        hashTable[hashedKey] = new StoredEmployee(key, employee);
    }

    public Employee get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1)
            return null;
        else
            return hashTable[hashedKey].getEmployee();
    }

    public Employee remove(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }

        Employee employee = hashTable[hashedKey].getEmployee();
        hashTable[hashedKey] = null;

//        Rehashing.
        StoredEmployee[] oldHashTable = hashTable;
        hashTable = new StoredEmployee[oldHashTable.length];
        for (StoredEmployee oldEmployee : oldHashTable) {
            if (oldEmployee != null)
                put(oldEmployee.getKey(), oldEmployee.getEmployee());
        }
        return employee;
    }

    public void printHashTable() {
        for (StoredEmployee storedEmployee : hashTable) {
            if (storedEmployee == null)
                System.out.println("Empty");
            else
                System.out.println(storedEmployee.getEmployee());
        }
    }

    public int findKey(String key) {
        int hashedKey = hashKey(key);
        if (hashTable[hashedKey] != null &&
                hashTable[hashedKey].getKey().equals(key))
            return hashedKey;

        int stopIndex = hashedKey;

        if (hashedKey == hashTable.length - 1)
            hashedKey = 0;
        else
            hashedKey++;

        while (hashedKey != stopIndex &&
                hashTable[hashedKey] != null &&
                !hashTable[hashedKey].getKey().equals(key))
            hashedKey = (hashedKey + 1) % hashTable.length;
        if (hashTable[hashedKey] != null &&
                hashTable[hashedKey].getKey().equals(key))
            return hashedKey;
        else
            return -1;
    }

    private boolean occupied(int index) {
        return hashTable[index] != null;
    }

    private int hashKey(String key) {
        return key.length() % hashTable.length;
    }
}
