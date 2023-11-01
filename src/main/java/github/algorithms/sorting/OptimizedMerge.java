package github.algorithms.sorting;

/**
 * This merge sort version consist of "Mergesort: practical improvements" from Robert Sedgewick course.
 * <p>practical improvements:</p>
 * <ol>
 * <li>Cutoff in a range of 7 items where mergeSort will be replaced by insertionSort for small size array</li>
 * <li>Stop if the biggest item in the first half is smallest then the first item in the second half (already sorted)</li>
 * <li>Eliminate the for loop copy of the aux array, by switching the role of the aux array (copy from original arr, to aux)</li>
 * </ol>
 */
@Sort
public class OptimizedMerge {

    private static final int CUTOFF = 5;

    public static void sort(int[] arr) {
        int[] aux = new int[arr.length];

        sort(arr, aux, 0, arr.length - 1);
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


}
