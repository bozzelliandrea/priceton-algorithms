package github.algorithms.sorting;

import github.algorithms.stack_and_queue.Collection;

@Sort(random = true)
public final class Shuffle {

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Collection.swap(arr, i, (int) (Math.random() * ((i) + 1)));
        }
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Collection.swap(arr, i, (int) (Math.random() * ((i) + 1)));
        }
    }
}
