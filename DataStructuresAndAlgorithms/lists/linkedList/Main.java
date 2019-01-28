package lists.linkedList;

public class Main {
    public static void main(String[] args) {

        Employee johnWick = new Employee("John", "Wick", 22);
        Employee johnShow = new Employee("John", "Snow", 1);
        Employee tonyStark = new Employee("Tony", "Stark", 23);
        Employee ragnorLothbrok = new Employee("Ragnor", "Lothbrok", 45);

        EmployeeLinkedList list = new EmployeeLinkedList();

        System.out.println(list.isEmpty());
        list.addToFront(johnWick);
        list.addToFront(johnShow);
        list.addToFront(tonyStark);
        list.addToFront(ragnorLothbrok);

        list.printList();
        System.out.println("Size = "+list.getSize());

        list.removeFromFront();
        System.out.println("Size = "+list.getSize());
        list.printList();
    }
}