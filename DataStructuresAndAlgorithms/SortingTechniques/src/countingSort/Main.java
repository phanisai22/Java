package countingSort;

class Main {
    public static void main(String[] args) {
        int[] list = { 2, 9, 5, 8, 2, 9, 2, 1, 1, 10 };

        countingSort(list, 1, 10);

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    private static void countingSort(int[] list, int min, int max) {
        int[] countArray = new int[(max - min) + 1];

        for (int i = 0; i < list.length; i++) {
            countArray[list[i] - 1]++;
        }

        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countArray[i - min] > 0) {
                list[j++] = i;
                countArray[i - min]--;
            }
        }
    }
}