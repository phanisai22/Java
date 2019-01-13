package theBank;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00, "2322-4501");

        // Creating threads

//        Thread t1 = new Thread() {
//            @Override
//            public void run() {
//                account.deposite(300.00);
//                System.out.println(account.toString());
//                account.withDraw(50.00);
//                System.out.println(account.toString());
//            }
//        };
//
//        Thread t2 = new Thread() {
//            @Override
//            public void run() {
//                account.deposite(203.23);
//                System.out.println(account.toString());
//                account.withDraw(100.00);
//                System.out.println(account.toString());
//                    }
//        };


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposite(300.00);
//                System.out.println(account.toString());
                account.withDraw(30.00);
//                System.out.println(account.toString());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposite(203.23);
//                System.out.println(account.toString());
                account.withDraw(100.00);
//                System.out.println(account.toString());
            }
        });


        // Starting threads

        t1.start();
        t2.start();
    }
}
