// Not working.
package mergeSort;

public class Main {
    public static void main(String[] args) {

        // Declaring the list to be sorted.
        int[] list = {23, 22, -1, 45, 0, 9};

        mergeSort(list, 0, list.length - 1);

        // Printing the sorted list.
        for (int ele : list) {
            System.out.println(ele);
        }
    }

    private static void mergeSort(int[] list, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(list, start, mid);
        mergeSort(list, mid +1, end);
        merge(list, start, mid, end);
    }

    private static void merge(int[] list, int start, int mid, int end) {
        if (list[mid - 1] <= list[mid]) {
            return;
        }

        int i = start;
        int j = mid + 1;
        int k = 0;

        int[] temp = new int[end - start + 1];

        while (i <= mid && j <= end) {
            temp[k++] = (list[i] < list[j]) ? list[i++] : list[j++];
        }

        while (i <= mid) {
            temp[k++] = list[i++];
        }

        while (j <= end) {
            temp[k++] = list[j++];
        }

//        System.arraycopy(list, 0, list, start + k, mid - i);
        System.arraycopy(temp, 0, list, start, k);
    }
}
