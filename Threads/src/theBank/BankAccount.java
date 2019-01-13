package theBank;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private double balance;
    private String accountNumber;
    private Lock lock;

    public BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.lock = new ReentrantLock();
    }

//    public synchronized void deposite(double amount) {
//        this.balance += amount;
//    }
//
//    public synchronized void withDraw(double amount) {
//        this.balance -= amount;
//    }


//    public void deposite(double amount) {
//        synchronized (this) {
//            this.balance += amount;
//        }
//    }
//
//    public void withDraw(double amount) {
//        synchronized (this) {
//            this.balance -= amount;
//        }
//    }


    public void deposite(double amount) {
        boolean status = false;
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    this.balance += amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }

        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Transaction status : " + status);
    }

    public void withDraw(double amount) {
        boolean status = false;
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    this.balance -= amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }

        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Transaction status : " + status);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number = " + this.accountNumber);
    }

    @Override
    public String toString() {
        return Thread.currentThread().getName() +
                "\n" + this.accountNumber + " : " + this.balance;
    }
}
