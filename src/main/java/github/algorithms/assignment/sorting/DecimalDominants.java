package github.algorithms.assignment.sorting;

import github.algorithms.stack_and_queue.Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array with n keys, design an algorithm to find all value that occur more than n/10 times.
 * The expected running time complexity should be linear O(n)
 */
public class DecimalDominants {

    public static void dijkstraQuickSort(int[] arr, int low, int high) {

        if (high <= low)
            return;

        int lt = low, i = low, gt = high;
        int pivot = arr[low];

        while (i <= gt) {
            if (arr[i] < pivot) {
                Collection.swap(arr, i, lt);
                i++;
                lt++;
            } else if (arr[i] > pivot) {
                Collection.swap(arr, i, gt);
                gt--;
            } else {
                i++; // if equals
            }
        }

        dijkstraQuickSort(arr, low, lt - 1);
        dijkstraQuickSort(arr, gt + 1, high);
    }

    public static List<Integer> countSorted(int[] arr, int times) {
        if (arr == null || arr.length == 0 || arr.length < times)
            return new ArrayList<>();

        List<Integer> valid = new ArrayList<>();
        int prev = arr[0];
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == prev)
                count++;
            else {
                if (count >= times)
                    valid.add(prev);
                prev = arr[i];
                count = 1;
            }
        }

        if (count >= times)
            valid.add(prev);

        return valid;
    }

    public static List<Integer> countNotSorted(int[] arr, int times) {
        if (arr == null || arr.length == 0 || arr.length < times)
            return new ArrayList<>();

        List<Integer> valid = new ArrayList<>();
        Map<Integer, Integer> counter = new HashMap<>();

        for (int j : arr)
            counter.put(j, counter.getOrDefault(j, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() >= times)
                valid.add(entry.getKey());
        }

        return valid;
    }

    public static List<Integer> count(final int[] arr, final int times) {
        return count(arr, times, true);
    }

    public static List<Integer> count(final int[] arr, final int times, final boolean isSorted) {
        return isSorted ? countSorted(arr, times) : countNotSorted(arr, times);
    }

    public static void main(String[] args) {
        int[] arr = {6, 6, 2, 3, 4, 1, 5, 7};

        dijkstraQuickSort(arr, 0, arr.length - 1);

        System.out.println(count(arr, 2));
    }
}
