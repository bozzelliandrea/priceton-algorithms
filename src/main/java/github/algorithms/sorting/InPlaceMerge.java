package github.algorithms.sorting;

import java.util.Arrays;

/**
 * Time Complexity: O(n2 * log(n))
 * Space Complexity: O(1)
 */
@Sort
public class InPlaceMerge {

    /**
     * primitive int merge sort
     *
     * @param arr input array to be sorted
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        if (high <= low)
            return;

        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {

        // if already sorted, then skip
        if (arr[mid] <= arr[mid + 1])
            return;

        // set the first index of the second half
        int low2 = mid + 1;

        // iterate until the two halves reach the end
        while (low <= mid && low2 <= high) {
            // if the left value is less then the first right half value, then increment left index
            if (arr[low] < arr[low2])
                low++;
            else {
                // store the current right half value and index
                int low2_val = arr[low2];
                int idx = low2;

                // shift all values to right and override the left index value with current right
                while (idx != low) {
                    arr[idx] = arr[idx - 1];
                    idx--;
                }
                arr[low] = low2_val;

                // increment all pointers, also "mid" index because we shift all values to right by 1
                low++;
                mid++;
                low2++;
            }
        }
    }


    public static void main(String[] args) {

        int[] arr = new int[]{5, 6, 72, 234, 1, 3, 29, 489, 30, 4, 90, 5, 73, 45, 23, 0, -5, -80, 8293};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * object array merge sort
     *
     * @param arr input array to be sorted
     */
    public static void sort(Comparable[] arr) {

    }

    private static void sort(Comparable[] arr, int low, int high) {

    }

    private static void sort(Comparable[] arr, int low, int mid, int high) {

    }
}
