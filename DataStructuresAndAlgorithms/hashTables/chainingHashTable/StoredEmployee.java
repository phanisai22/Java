package hashTables.chainingHashTable;

public class StoredEmployee {
    private String key;
    private Employee employee;

    public StoredEmployee(String key, Employee employee) {
        this.key = key;
        this.employee = employee;
    }

    public String getKey() {
        return key;
    }

    public Employee getEmployee() {
        return employee;
    }
}
