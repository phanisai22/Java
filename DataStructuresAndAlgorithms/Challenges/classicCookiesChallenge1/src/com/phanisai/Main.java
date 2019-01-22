package com.phanisai;

public class Main {

    private final static int SIZE = 5;

    public static void main(String[] args) {

        int[][] cookie = new int[][]{
                {1, 0, 1, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0},
        };

        int[] lengthOfChocolateChip = new int[10];
        int k = 0;

        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
//                Loops that traverse cookie in vertical order.
                if (cookie[i][j] == 1) {
                    lengthOfChocolateChip[k] = 0;
                    for (int l = i; l < SIZE && cookie[i][j] == 1; l++) {
                        lengthOfChocolateChip[k]++;
                        i++;
                    }
                    k++;
                }
            }
        }

        int i;
        for (i = 0; (i < (lengthOfChocolateChip.length)) && (lengthOfChocolateChip[i] != 0); i++) {
            System.out.print(lengthOfChocolateChip[i] + "\t");
        }

        System.out.println("\nNumber of chocolate chips = " + i);
    }
}
