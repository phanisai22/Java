package lists.linkedList;

public class EmployeeLinkedList {
    private EmployeeNode head;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
        size++ ;
    }

    public Employee removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        EmployeeNode removedNode = head;
        head = head.getNext();
        removedNode.setNext(null);
        size--;
        return removedNode.getEmployee();
    }

    public int getSize() {
        return size;
    }

    public void printList() {
        EmployeeNode current = head;
        System.out.println("Head -> ");
        while (current != null) {
            System.out.println(current + " -> ");
            current = current.getNext();
        }
        System.out.println("Null");
    }

    public boolean isEmpty(){
        if (head == null) {
            return true;
        }
        return false;
    }
}
