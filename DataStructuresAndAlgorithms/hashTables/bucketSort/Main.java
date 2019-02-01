package hashTables.bucketSort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] list = {22, 23, 0, -1, 45, 9};

        bucketSort(list);

        for (int item : list) System.out.println(item);
    }

    private static void bucketSort(int[] list) {
        List<Integer>[] buckets = new List[10];

        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {
            buckets[hash(list[i])].add(list[i]);
        }

        for (List bucket : buckets) {
            Collections.sort(bucket);
        }

        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int value : buckets[i])
                list[j++] = value;
        }
    }

    private static int hash(int value) {
        return value / (int) 10 % 10;
    }
}
