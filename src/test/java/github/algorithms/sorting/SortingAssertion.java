package github.algorithms.sorting;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class SortingAssertion {

    static final int[] RANDOM_ARRAY = {3, 5, 2, 1, 300, 98, 67, 23, 19, 82, 376, 2, 55};
    static final int[] EXPECTED_ARRAY = {1, 2, 2, 3, 5, 19, 23, 55, 67, 82, 98, 300, 376};

    public static void assertSorted(SortingInt sortingInt) {
        int[] toBeSorted = RANDOM_ARRAY.clone();
        sortingInt.sort(toBeSorted);

        Assertions.assertEquals(
                Arrays.toString(EXPECTED_ARRAY),
                Arrays.toString(toBeSorted)
        );
    }

    public static void assertSorted(Sorting sortingInt) {
        Integer[] toBeSorted = {1, 3, 4, 52, 4, 25, 4, 35, 53, 3244, 6, 456, 7, 112};
        sortingInt.sort(toBeSorted);

        Assertions.assertEquals(
                Arrays.toString(new Integer[]{1, 3, 4, 4, 4, 6, 7, 25, 35, 52, 53, 112, 456, 3244}),
                Arrays.toString(toBeSorted)
        );
    }
}
