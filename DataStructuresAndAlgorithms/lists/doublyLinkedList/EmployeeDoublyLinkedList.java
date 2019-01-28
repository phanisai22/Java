package lists.doublyLinkedList;

public class EmployeeDoublyLinkedList {
    private EmployeeNode head;
    private EmployeeNode tail;
    private static int size;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        if (head == null)
            tail = node;
        else
            node.setPrevious(head);
        head = node;
        size++;
    }

    public void addToEnd(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        if (tail == null)
            head = node;
        else {
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        size++;
    }

    public boolean addBefore(Employee newEmployee, Employee existingEmployee) {

        if (isEmpty())
            return false;

        EmployeeNode current = head;
        while (current != null && !current.getEmployee().equals(existingEmployee))
            current = current.getNext();

        if (current == null)
            return false;

        EmployeeNode newNode = new EmployeeNode(newEmployee);
        newNode.setPrevious(current.getPrevious());
        newNode.setNext(current);
        current.setPrevious(newNode);

        if (head == current)
            head = newNode;
        else
            newNode.getPrevious().setNext(newNode);

        size++;
        return true;
    }

    public EmployeeNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        EmployeeNode removedNode = head;
        if (head.getNext() == null)
            tail = null;
        else
            head.getNext().setPrevious(null);

        head = head.getNext();
        removedNode.setNext(null);
        size--;
        return removedNode;
    }

    public EmployeeNode removeFromEnd() {
        if (isEmpty()) {
            return null;
        }

        EmployeeNode removedNode = tail;
        if (tail.getPrevious() == null)
            head = null;
        else
            tail.getPrevious().setNext(null);

        tail = tail.getPrevious();
        removedNode.setPrevious(null);
        size--;
        return removedNode;
    }

    public int getSize() {
        return size;
    }

    public void printList() {
        EmployeeNode current = head;
        System.out.println("Head -> ");
        while (current != null) {
            System.out.println(current + " <-> ");
            current = current.getNext();
        }
        System.out.println("<- Tail");
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }
}
