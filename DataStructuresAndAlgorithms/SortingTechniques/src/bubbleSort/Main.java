package bubbleSort;

public class Main {
    public static void main(String[] args) {

        // Declaring the list to be sorted.
        int[] list = {23, 22, -1, 45, 0, 9};

        // Sorted array is obtained from the end of the list.
        for (int lastUnsortedIndex = list.length - 1; lastUnsortedIndex > 0;
             lastUnsortedIndex--) {
            // Looping through every element in the list linearly.
            for (int i = 0; i < lastUnsortedIndex; i++) {
                // It is a Stable Algorithm >= makes the difference.
                if (list[i] > list[i + 1])
                    swap(list, i, i + 1);
            }
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
