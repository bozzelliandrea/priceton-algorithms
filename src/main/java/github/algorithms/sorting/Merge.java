package github.algorithms.sorting;

import java.util.Arrays;

/**
 * merge sort with auxiliary array
 * Time Complexity: O(N logN)
 * Space Complexity: O(N) recursive stack + aux array space
 */
@Sort
public final class Merge {

    /**
     * object array merge sort
     *
     * @param arr input array to be sorted
     */
    public static <T> void sort(Comparable<T>[] arr) {
        sort(arr, new Comparable[arr.length], 0, arr.length - 1);
    }

    private static <T> void sort(Comparable<T>[] arr, Comparable<T>[] aux, int low, int high) {

        if (high <= low)
            return;

        int mid = low + (high - low) / 2;
        sort(arr, aux, low, mid);
        sort(arr, aux, mid + 1, high);

        merge(arr, aux, low, mid, high);
    }

    private static void merge(Comparable[] arr, Comparable[] aux, int low, int mid, int high) {

        for (int k = low; k <= high; k++)
            aux[k] = arr[k];

        int i = low, j = mid + 1;

        for (int k = low; k <= high; k++) {
            if (i > mid)
                arr[k] = aux[j++];
            else if (j > high)
                arr[k] = aux[i++];
            else if (aux[j].compareTo(aux[i]) < 0)
                arr[k] = aux[j++];
            else
                arr[k] = aux[i++];
        }
    }

    /**
     * primitive int merge sort
     *
     * @param arr input array to be sorted
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        sort(arr, new int[arr.length], 0, arr.length - 1); // immediately avoid index out of bound
    }

    private static void sort(int[] arr, int[] aux, int low, int high) {
        // base case
        if (high <= low)
            return;

        // recursion divide
        int mid = low + (high - low) / 2;
        sort(arr, aux, low, mid);
        sort(arr, aux, mid + 1, high);

        // conquer merge
        merge(arr, aux, low, mid, high);
    }

    private static void merge(int[] arr, int[] aux, int low, int mid, int high) {

        for (int k = low; k <= high; k++)
            aux[k] = arr[k];

        int i = low, j = mid + 1;

        for (int k = low; k <= high; k++) {
            if (i > mid)
                arr[k] = aux[j++];
            else if (j > high)
                arr[k] = aux[i++];
            else if (aux[i] < aux[j])
                arr[k] = aux[i++];
            else
                arr[k] = aux[j++];
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{5, 6, 72, 234, 1, 3, 29, 489, 30, 4, 90, 5, 73, 45, 23, 0,-5, -80,8293};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
