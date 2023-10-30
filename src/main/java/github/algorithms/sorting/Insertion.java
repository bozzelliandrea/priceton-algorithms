package github.algorithms.sorting;

import github.algorithms.stack_and_queue.Collection;

@Sort
public final class Insertion {

    public static void sort(int[] arr) {
        int size = arr.length;

        for (int i = 1; i < size; i++)
            for (int j = i; j > 0; j--)
                if (arr[j] < arr[j - 1])
                    Collection.swap(arr, j, j - 1);
                else
                    break;
    }

    public static void sort(int[] arr, int low, int high) {
        for (int i = low; i <= high; i++)
            for (int j = i; j > 0; j--)
                if (arr[j] < arr[j - 1])
                    Collection.swap(arr, j, j - 1);
                else
                    break;
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = 1; i < arr.length; i++)
            for (int j = i; j > 0; j--)
                if (arr[j].compareTo(arr[j - 1]) < 0)
                    Collection.swap(arr, j, j - 1);
                else break;
    }
}
