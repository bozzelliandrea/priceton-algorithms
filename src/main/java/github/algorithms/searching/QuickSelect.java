package github.algorithms.searching;

import github.algorithms.stack_and_queue.Collection;

public class QuickSelect {

    /**
     * Find the kth smallest value in the given array.
     *
     * @return the value
     * @throws IndexOutOfBoundsException if k is greater than the input array size
     */
    public static int find(int[] arr, int k) throws IndexOutOfBoundsException {
        if (arr == null || arr.length == 0 || arr.length < k)
            throw new IndexOutOfBoundsException("K is greater than input array");

        int low = 0, high = arr.length - 1;

        while (low < high) {
            int p = partition(arr, low, high);

            if (p < k)
                low = p + 1;
            else if (p > k)
                high = p - 1;
            else
                return arr[k];
        }

        return arr[k];
    }

    private static int partition(int[] arr, int low, int high) {
        int partition = arr[high];
        int i = low;

        for (int j = low; j <= high; j++) {
            if (arr[j] < partition)
                Collection.swap(arr, j, i++);
        }

        Collection.swap(arr, i, high);
        return i;
    }

    public static void main(String[] args) {

        // [-80, -5, 0, 1, 3, 4, 5, 5, 6, 23, 29, 30, 45, 45, 72, 73, 90, 234, 489, 8293]
        int[] arr = new int[]{5, 6, 72, 234, 1, 3, 29, 489, 30, 4, 90, 5, 73, 45, 45, 0, -5, -80, 8293, 23};

        System.out.println(find(arr, 1));
    }
}
