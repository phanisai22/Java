package Messages;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        messages message = new messages();
        (new Thread(new writer(message))).start();
        (new Thread(new reader(message))).start();
    }
}

class messages {
    private String message;
    private boolean empty = true;

    public synchronized String read() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        empty = false;
        notifyAll();
        return message;
    }

    public synchronized void write(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        empty = true;
        notifyAll();
        this.message = message;
    }
}

class writer implements Runnable {

    private messages message;

    public writer(messages message) {
        this.message = message;
    }

    Random random = new Random();

    @Override
    public void run() {
        String[] messages = {
                "Humpty Dumpty sat on a wall",
                "Humpty Dumpty had a great fall",
                "All the King's horses and all the King's men",
                "Couldn't put Humpty together again."
        };

        for (int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
        message.write("Finished");
    }
}

class reader implements Runnable {
    private messages message;

    public reader(messages message) {
        this.message = message;
    }

    public void run() {
        Random random = new Random();
        for (String latestMessage = message.read();
             !latestMessage.equals("Finished");
             latestMessage = message.read()) {

            System.out.println(latestMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
    }
}
