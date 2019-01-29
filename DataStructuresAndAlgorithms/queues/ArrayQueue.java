package queues;

import java.util.NoSuchElementException;

public class ArrayQueue {

    private Employee[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void enqueue(Employee employee) {
        if (back == queue.length) {
            Employee[] newQueue = new Employee[2 * queue.length];
            System.arraycopy(queue, 0, newQueue, 0, queue.length);
            queue = newQueue;
        }

        queue[back] = employee;
        back++;
    }

    public Employee dequeue() {
        if (size() == 0)
            throw new NoSuchElementException();

        Employee employee = queue[front];
        queue[front] = null;
        front++;

        if (size() == 0) {
            front = back = 0;
        }

        return employee;
    }

    public Employee peek() {
        if (size() == 0)
            throw new NoSuchElementException();

        return queue[front];
    }

    public int size() {
        return back - front;
    }

    public void printQueue() {
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }

}
