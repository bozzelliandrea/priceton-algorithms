package github.algorithms.sorting;

import github.algorithms.searching.BinarySearch;
import github.algorithms.stack_and_queue.Collection;

import java.util.Arrays;

@Sort
public class Quick {

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        quickSort(arr, 0, arr.length - 1);
    }

    public static void sort(Comparable[] arr) {
        if (arr == null || arr.length == 0)
            return;

        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (high <= low)
            return;

        int p = partition(arr, low, high);
        quickSort(arr, low, p - 1);
        quickSort(arr, p + 1, high);
    }

    /**
     * Right partition version (most common way)
     * Place all the element smaller than the partition at the left, and the bigger to the right
     * - initialize the partition equals arr[high]
     * - initialize i index equals to low
     * - for: from low equals to high
     * - if current val at index < partition, then swap and increment i
     * - swap high (partition index) with i (new partition)
     * - return i
     */
    private static int partition(int[] arr, int low, int high) {

        int partition = arr[high];
        int i = low;

        for (int j = low; j <= high; j++) {
            if (arr[j] < partition) {
                Collection.swap(arr, i, j);
                i++;
            }
        }

        Collection.swap(arr, i, high);
        return i;
    }

    /**
     * Sedgewick version of quickSort partition (using first arr value, left partitioned):
     * - initialize i as low idx and j as high + 1
     * - don't need to initialize a new partition pointer, using low input param as partition
     * - while true
     * - while: scan i from left to right so long as a[i] < a[partition]
     * - increment i, if i is equals to high, break
     * - while: scan j from right to left so long as a[j] > a[partition]
     * - decrement j, if j is equals to low, break
     * - swap arr value between "i" and "j"
     * - swap arr value between j and partition (low)
     * - return j (new partition index)
     */
    private static int partition2(int[] arr, int low, int high) {
        int i = low, j = high + 1;

        while (true) {
            while (arr[++i] < arr[low])
                if (i == high)
                    break;
            while (arr[--j] > arr[low])
                if (j == low)
                    break;

            if (i >= j) break;
            Collection.swap(arr, i, j);
        }

        Collection.swap(arr, low, j);
        return j;
    }

    private static void quickSort(Comparable[] arr, int low, int high) {
        if (high <= low)
            return;

        int partition = partition(arr, low, high);
        quickSort(arr, low, partition - 1);
        quickSort(arr, partition + 1, high);
    }

    private static int partition(Comparable[] arr, int low, int high) {

        Comparable partition = arr[high];
        int i = low;

        for (int j = low; j <= high; j++) {
            if (arr[j].compareTo(partition) < 0) {
                Collection.swap(arr, j, i);
                i++;
            }
        }

        Collection.swap(arr, i, high);
        return i;
    }

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{5, 6, 72, 234, 1, 3, 29, 489, 30, 4, 90, 5, 73, 45, 45, 0, -5, -80, 8293, 23};

        sort(arr);

        System.out.println(Arrays.toString(arr));

        int index = BinarySearch.search(arr, 5);

        System.out.println(index);
        System.out.println(index >= 0 ? arr[index] : "Not Found");
    }
}
