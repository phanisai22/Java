package selectionSort;

public class Main {
    public static void main(String[] args) {

        // Declaring the list to be sorted.
        int[] list = {23, 22, -1, 45, 0, 9};

        // Sorted array is obtained from the end of the list.
        for (int lastUnsortedIndex = list.length - 1; lastUnsortedIndex > 0;
             lastUnsortedIndex--) {

            // Assuming list[0] is the largest so far
            // Therefore, assigning index 0 to largest.
            int largest = 0;

            // Looping through every element in the list linearly.
            for (int i = 0; i <= lastUnsortedIndex; i++) {
                // Selection sort is Unstable algorithm.
                if (list[i] > list[largest])
                    largest = i;
            }
            swap(list, largest, lastUnsortedIndex);
        }

        // Printing the sorted list.
        for (int ele : list) {
            System.out.println(ele);
        }
    }

    //    Method swaps the elements at positions "i", "j" .
    private static void swap(int[] list, int i, int j) {

        // No need to swap the elements in the same index.
        if (i == j)
            return;

        // Swap ...
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
