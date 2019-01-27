package radixSort;

class Main {
    public static void main(String[] args) {
        int[] list = { 1234, 1034, 4563, 6543, 2322, 5093, 6786 };

        radixSort(list, 10, 4);

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    private static void radixSort(int[] list, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(list, i, radix);
        }
    }

    private static void radixSingleSort(int[] list, int position, int radix) {
        int numItems = list.length;
        int[] countArray = new int[radix];

        for (int value : list) {
            countArray[getDigit(position, value, radix)]++;
        }

        // Adjust the count array.
        for (int i = 1; i < radix; i++) {
            countArray[i] += countArray[i - 1];
        }

        int[] temp = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, list[tempIndex], radix)]] = list[tempIndex];
        }

        for (int i = 0; i < numItems; i++) {
            list[i] = temp[i];
        }
    }

    private static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(10, position) % radix;
    }
}