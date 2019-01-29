package queues;

public class Main {
    public static void main(String[] args) {
        Employee joker = new Employee("Joker", "J", 25);
        Employee walterWhite = new Employee("Walter", "White", 56);
        Employee johnWick = new Employee("John", "Wick", 22);
        Employee johnShow = new Employee("John", "Snow", 1);
        Employee tonyStark = new Employee("Tony", "Stark", 23);
        Employee ragnorLothbrok = new Employee("Ragnor", "Lothbrok", 45);

        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(joker);
        queue.enqueue(walterWhite);
        queue.enqueue(johnShow);
        queue.enqueue(johnWick);
        queue.enqueue(tonyStark);
        queue.enqueue(ragnorLothbrok);

        queue.printQueue();

        System.out.println(queue.dequeue());
    }
}
