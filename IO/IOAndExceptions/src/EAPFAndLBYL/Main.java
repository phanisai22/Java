package EAPFAndLBYL;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // int i = getInt();
        // int j = getInt();
        // divideLBYL(22, 0);
        // divideEAFP(22, 0);
        // divide(i, j);

        // System.out.println(getIntLBYL());
        // System.out.println(getIntEAFP());

        try {

            int i = sc.nextInt();
            int j = sc.nextInt();

            // divide(22, 0);
            divide(i, j);

        } catch(ArithmeticException | InputMismatchException e) {
            System.out.println("Unable to perform division");
            System.out.println(e.toString());
        }


    }

    private static void divide(int x, int y) {
        System.out.println(x / y);
    }

    private static int getInt() {
        int i = sc.nextInt();
        return i;
    }

    // Look Before You Leap.
    private static void divideLBYL(int x, int y) {
        if (y == 0) {
            System.out.println(y);
        } else {
            System.out.println(x / y);
        }
    }

    private static int getIntLBYL() {
        String i = sc.next();
        boolean isValue = true;

        for (int j = 0; j < i.length(); j++) {
            if(!Character.isDigit(i.charAt(j))){
                isValue = false;
                break;
            }
        }

        if (isValue) {
            return Integer.parseInt(i) ;
        }

        return 0 ;
    }

    // Easy to Ask For Forgiveness Than Permission
    private static void divideEAFP(int x, int y) {
        try {
            System.out.println(x / y);
        } catch (ArithmeticException e) {
            System.out.println(y);
        }
    }

    private static int getIntEAFP() {
        // String number = sc.next();
        int number ;
        try {
            number = sc.nextInt();
        } catch(InputMismatchException e ){
            return 0;
        }

        return number;
    }

}