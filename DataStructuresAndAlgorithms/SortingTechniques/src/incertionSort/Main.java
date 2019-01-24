package incertionSort;

public class Main {
    public static void main(String[] args) {

        // Declaring the list to be sorted.
        int[] list = {23, 22, -1, 45, 0, 9};

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < list.length;
             firstUnsortedIndex++) {
            int temp = list[firstUnsortedIndex];
            int i;
            // Stable sort
            for (i = firstUnsortedIndex; (i > 0 && list[i - 1] > temp); i--) {
                list[i] = list[i - 1];
            }

            list[i] = temp;

        }

        // Printing the sorted list.
        for (int ele : list) {
            System.out.println(ele);
        }
    }
}
