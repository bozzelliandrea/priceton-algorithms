package github.algorithms.sorting;

import github.algorithms.stack_and_queue.Collection;

@Sort
public class Selection {

    public static void sort(int[] arr) {
        int size = arr.length;

        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            Collection.swap(arr, min, i);
        }
    }

}
