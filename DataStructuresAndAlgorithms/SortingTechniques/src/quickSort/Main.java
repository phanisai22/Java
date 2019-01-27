package quickSort;

public class Main {
    public static void main(String[] args) {

        // Declaring the list to be sorted.
        int[] list = { 23, 22, -1, 45, 0, 9 };

        quickSort(list, 0, list.length);
        // Printing the sorted list.
        for (int ele : list) {
            System.out.println(ele);
        }
    }

    private static void quickSort(int[] list, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int pivotIndex = partition(list, start, end);
        quickSort(list, start, pivotIndex);
        quickSort(list, pivotIndex + 1, end);
    }

    private static int partition(int[] list, int start, int end) {
        // This is using the first element as the pivot.
        int pivot = list[start];
        int i = start;
        int j = end;

        while (i < j) {

            // NOTE: this is an empty loop.
            while (i < j && list[--j] >= pivot)
                ;
            if (i < j) {
                list[i] = list[j];
            }

            // NOTE: this is an empty loop.
            while (i < j && list[++i] <= pivot)
                ;
            if (i < j) {
                list[j] = list[i];
            }
        }
        list[j] = pivot;
        return j;
    }
}
