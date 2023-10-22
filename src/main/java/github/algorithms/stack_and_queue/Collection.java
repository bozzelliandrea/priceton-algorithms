package github.algorithms.stack_and_queue;

import java.io.Serializable;

public interface Collection extends Serializable {

    int size();

    default boolean isEmpty() {
        return this.size() == 0;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
