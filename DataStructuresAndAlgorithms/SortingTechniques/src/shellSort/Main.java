package shellSort;

public class Main {
    public static void main(String[] args) {

        // Declaring the list to be sorted.
        int[] list = {23, 22, -1, 45, 0, 9};

        for (int gap = list.length / 2; gap > 0; gap /= 2) {
            // Calculating the gap value (In this case 2 iterations).
            // Starting with the large gap and iterate until gap = 1;
            for (int i = gap; i < list.length; i++) {
                // By first iteration the number of shiftings are reduced.
                // When gap = 1 this works as a Insertion Sort(which is second iteration).
                int temp = list[i];
                int j = i;
                while (j >= gap && (temp < list[j - gap])) {
                    list[j] = list[j - gap];
                    j -= gap;
                }
                list[j] = temp;
            }
        }

        // Printing the sorted list.
        for (int ele : list) {
            System.out.println(ele);
        }
    }
}
