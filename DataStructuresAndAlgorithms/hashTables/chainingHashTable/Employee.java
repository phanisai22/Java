package hashTables.chainingHashTable;

public class Employee {
    private String firstName;
    private String lastName;
    private int id;

    public Employee(String fname, String lname, int id) {
        firstName = fname;
        lastName = lname;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Name : " + firstName + " " + lastName + "\t"
                + "Id : " + id;
    }
}
