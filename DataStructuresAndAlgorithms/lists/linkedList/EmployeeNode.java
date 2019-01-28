package lists.linkedList;

public class EmployeeNode {

    private Employee employee;
    private EmployeeNode next;

    public EmployeeNode(Employee employee) {
        this.employee = employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setNext(EmployeeNode next) {
        this.next = next;
    }

    public Employee getEmployee() {
        return employee;
    }

    public EmployeeNode getNext() {
        return next;
    }

    @Override
    public String toString() {
        return employee.toString();
    }
}
