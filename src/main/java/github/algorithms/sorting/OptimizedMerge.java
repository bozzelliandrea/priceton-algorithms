package github.algorithms.sorting;

import java.util.Arrays;

@Sort
public class OptimizedMerge {

    private static final int CUTOFF = 5;

    public static void sort(int[] arr) {
        sort(arr, new int[arr.length], 0, arr.length - 1);
    }

    private static void sort(int[] arr, int[] aux, int low, int high) {

        if (high <= low + CUTOFF) {
            Insertion.sort(arr, low, high);
            return;
        }

        int mid = low + (high - low) / 2;

        sort(aux, arr, low, mid);
        sort(aux, arr, mid + 1, high);

        if (aux[mid] < aux[mid + 1])
            return;

        merge(arr, aux, low, mid, high);
    }

    private static void merge(int[] arr, int[] aux, int low, int mid, int high) {
        int i = low, j = mid + 1;

        for (int k = low; k <= high; k++) {
            if (i > mid)
                aux[k] = arr[j++];
            else if (j > high)
                aux[k] = arr[i++];
            else if (arr[j] < arr[i])
                aux[k] = arr[j++];
            else
                aux[k] = arr[i++];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 3, 5, 1, 19, 5, 22, 11, 13, 97, 77, 34, 85, 23, 56, 34, 54, 29, 28};

        long start = System.nanoTime();
        sort(arr);
        long end = System.nanoTime();
        System.out.println("Elapsed Time in milli seconds: " + (end - start));


        System.out.println(Arrays.toString(arr));
    }
}
