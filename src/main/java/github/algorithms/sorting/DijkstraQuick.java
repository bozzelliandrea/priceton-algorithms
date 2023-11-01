package github.algorithms.sorting;

import github.algorithms.stack_and_queue.Collection;

import java.util.Arrays;

/**
 * Quick sort algorithms version for input array with multiple duplicates values.
 * also known as 3 way quick sorting
 */
@Sort
public class DijkstraQuick {


    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        dijkstraQuickSort(arr, 0, arr.length - 1);
    }

    /**
     * - initialize lt as low window, gt as high window
     * - partition from low (left partitioned)
     * - i from low (left partitioned)
     * - while: until i <= gt (left to right scan)
     * - if a[i] < partition, swap lt and i and increment both
     * - if a[i] > partition, swap gt and i, decrement only gt
     * - if a[i] == partition, increment i
     */
    private static void dijkstraQuickSort(int[] arr, int low, int high) {

        if (high <= low)
            return;

        int lt = low, gt = high;
        int partition = arr[low];
        int i = low;

        while (i <= gt) {
            if (arr[i] < partition)
                Collection.swap(arr, i++, lt++);
            else if (arr[i] > partition)
                Collection.swap(arr, i, gt--);
            else
                i++;
        }

        dijkstraQuickSort(arr, low, lt - 1);
        dijkstraQuickSort(arr, gt + 1, high);
    }

    public static void main(String[] args) {

        int[] arr = new int[]{5, 6, 72, 234, 1, 3, 29, 29, 29, 29, 489, 30, 4, 90, 5, 73, 45, 45, 45, 45, 45, 45, 0, -5, -80, -80, -80, -80, -80, -80, -80, 8293, 23};

        sort(arr);

        System.out.println(Arrays.toString(arr));

    }
}
