package inbuiltSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Declaring the list to be sorted.
        int[] list = {23, 22, -1, 45, 0, 9};

        Arrays.sort(list); // double pivot quick sort
        Arrays.parallelSort(list); // merge sort that uses quick sort and threads.
 
        // Printing the sorted list.
        for (int ele : list) {
            System.out.println(ele);
        }
    }
}