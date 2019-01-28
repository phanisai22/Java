package lists.doublyLinkedList;

public class Main {
    public static void main(String[] args) {

        Employee johnWick = new Employee("John", "Wick", 22);
        Employee johnShow = new Employee("John", "Snow", 1);
        Employee tonyStark = new Employee("Tony", "Stark", 23);
        Employee ragnorLothbrok = new Employee("Ragnor", "Lothbrok", 45);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();

        list.addToFront(johnWick);
        list.addToFront(johnShow);
        list.addToFront(tonyStark);
        list.addToFront(ragnorLothbrok);

        list.printList();
        System.out.println(list.getSize());

        Employee walterWhite = new Employee("Walter", "White", 56);
        list.addToEnd(walterWhite);

        list.printList();
        System.out.println(list.getSize());

        list.removeFromFront();
//        list.removeFromFront();
//        list.removeFromFront();
//        list.removeFromFront();
//        list.removeFromFront();
//        list.removeFromFront();

        list.printList();
        System.out.println(list.getSize());

        list.removeFromEnd();
//        list.removeFromEnd();
//        list.removeFromEnd();
//        list.removeFromEnd();
//        list.removeFromEnd();

        list.printList();
        System.out.println(list.getSize());

        Employee joker = new Employee("Joker", "J", 25);
        list.addBefore(joker, tonyStark);

        list.printList();
        System.out.println(list.getSize());
    }
}