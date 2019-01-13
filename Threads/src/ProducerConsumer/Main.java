package ProducerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static ProducerConsumer.Main.EOF;

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {

//        List<String> buffer = new ArrayList<>();
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);
//        ReentrantLock lock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

//        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW, lock);
//        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, lock);
//        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN, lock);

        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_GREEN + "I'm from callable class");
                return "This is the callable result";
            }
        });

        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error : " + e.getMessage());
        }

        executorService.shutdown();
    }

}

class MyProducer implements Runnable {
    //    private List<String> buffer;
    private ArrayBlockingQueue<String> buffer;
    private String color;
//    private ReentrantLock lock;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
//        this.lock = lock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String number : nums) {
            try {
                System.out.println(color + "Adding ..." + number);
                buffer.put(number);
//                lock.lock();
//                buffer.add(number);
//                lock.unlock();
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted.");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
//        lock.lock();
//        buffer.add("EOF");
//        lock.unlock();

        try {
            buffer.put("EOF");
        } catch (InterruptedException e) {
            System.out.println("Error :" + e.getMessage());
        }
    }
}


class MyConsumer implements Runnable {
    //    private List<String> buffer;
    private ArrayBlockingQueue<String> buffer;
    private String color;
//    private ReentrantLock lock;

//    private int counter = 0;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
//        this.lock = lock;
    }

    public void run() {
//        while (true) {
//            if (lock.tryLock()) {
//                try {
//                    if (buffer.isEmpty()) {
//                        continue;
//                    }
//
//                    System.out.println("counter = " + counter);
//                    if (buffer.get(0).equals(EOF)) {
//                        System.out.println(color + "Exiting...");
//                        break;
//                    } else {
//                        System.out.println(color + "Removing ... " + buffer.remove(0));
//                    }
//                } finally {
//                    lock.unlock();
//                }
//            } else {
//                counter++;
//            }
//        }

        synchronized (buffer) {
            while (true) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }

                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting...");
                        break;
                    } else {
                        System.out.println(color + "Removing ... " + buffer.take());
                    }
                } catch (InterruptedException e) {
                    System.out.println("Error : " + e.getMessage());
                }
            }
        }
    }
}
