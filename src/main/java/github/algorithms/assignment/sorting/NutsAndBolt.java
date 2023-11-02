package github.algorithms.assignment.sorting;

import github.algorithms.stack_and_queue.Collection;

import java.util.Arrays;

/**
 * Nuts and bolts.
 * A disorganized carpenter has a mixed pile of n nuts and n bolts; The goal is to find the corresponding pairs of them.
 * Each nut fits exactly one bolt and each bolt fits exactly one nut. By fitting a nut and a bolt together,
 * the carpenter can see which one is bigger (but the carpenter cannot compare two nuts or two bolts directly)
 * <br/><br/>
 * Design an algorithm for the problem that uses at most O(n log n) time complexity
 */
public class NutsAndBolt {

    public static void match(char[] nuts, char[] bolts) {
        if (nuts == null || bolts == null
                || nuts.length == 0 || bolts.length == 0
                || nuts.length != bolts.length)
            return;

        quickSort(nuts, bolts, 0, nuts.length - 1);
    }

    private static void quickSort(char[] nuts, char[] bolts, int low, int high) {
        if (high <= low)
            return;

        int partition = partition(nuts, low, high, nuts[high]);
        partition(bolts, low, high, nuts[partition]);

        quickSort(nuts, bolts, low, partition - 1);
        quickSort(nuts, bolts, partition + 1, high);
    }

    private static int partition(char[] arr, int low, int high, char pivot) {
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                Collection.swap(arr, i, j);
                i++;
            } else if (arr[j] == pivot) {
                Collection.swap(arr, j, high);
                j--;
            }
        }

        Collection.swap(arr, i, high);
        return i;
    }

    public static void match(int[] nuts, int[] bolts) {
        if (nuts == null || bolts == null
                || nuts.length == 0 || bolts.length == 0
                || nuts.length != bolts.length)
            return;

        quickSort(nuts, bolts, 0, nuts.length - 1);
    }

    private static void quickSort(int[] nuts, int[] bolts, int low, int high) {
        if (high <= low)
            return;

        int partition = partition(nuts, low, high, nuts[high]);
        partition(bolts, low, high, nuts[partition]);

        quickSort(nuts, bolts, low, partition - 1);
        quickSort(nuts, bolts, partition + 1, high);
    }

    private static int partition(int[] arr, int low, int high, int partition) {
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] < partition) {
                Collection.swap(arr, i, j);
                i++;
            } else if (arr[j] == partition) {
                Collection.swap(arr, j, high);
                j--;
            }
        }

        Collection.swap(arr, i, high);
        return i;
    }

    /**
     * Classic quick sort single array
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (high <= low)
            return;

        int p = partition(arr, low, high);

        quickSort(arr, low, p - 1);
        quickSort(arr, p + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int i = low;
        int pivot = arr[high];

        for (int j = low; j < high; j++)
            if (arr[j] < pivot)
                Collection.swap(arr, i++, j);

        Collection.swap(arr, i, high);
        return i;
    }


    public static void main(String[] args) {
        long start1, end1;

        char[] nuts_c = {'d', 'b', 'c', 'e', 'a', 'f'};
        char[] bolts_c = {'f', 'c', 'b', 'd', 'a', 'e'};

        start1 = System.nanoTime();
        match(nuts_c, bolts_c);
        end1 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: " + (end1 - start1));

        System.out.println(Arrays.toString(nuts_c));
        System.out.println(Arrays.toString(bolts_c));

        int[] nuts = {6, 2, 3, 4, 1, 5, 7};
        int[] bolts = {4, 2, 3, 7, 6, 1, 5};

        start1 = System.nanoTime();
        match(nuts, bolts);
        end1 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: " + (end1 - start1));

        System.out.println(Arrays.toString(nuts));
        System.out.println(Arrays.toString(bolts));

        nuts = new int[]{6, 2, 3, 4, 1, 5, 7};
        bolts = new int[]{4, 2, 3, 7, 6, 1, 5};

        start1 = System.nanoTime();
        quickSort(nuts, 0, nuts.length - 1);
        quickSort(bolts, 0, nuts.length - 1);
        end1 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: " + (end1 - start1));

        System.out.println(Arrays.toString(nuts));
        System.out.println(Arrays.toString(bolts));
    }

}
