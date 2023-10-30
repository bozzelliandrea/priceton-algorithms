package github.algorithms.sorting;

import java.util.Arrays;

/**
 * merge sort with auxiliary array
 * Time Complexity: O(N logN)
 * Space Complexity: O(N) recursive stack + aux array space
 */
@Sort
public final class Merge {

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

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 6, 3, 5, 1, 19, 5, 22, 11, 13, 97, 77, 34, 85, 23, 56, 34, 54, 29, 28};

        long start = System.nanoTime();
        sort(arr);
        long end = System.nanoTime();
        System.out.println("Elapsed Time in milli seconds: " + (end - start));


        System.out.println(Arrays.toString(arr));
    }
}
