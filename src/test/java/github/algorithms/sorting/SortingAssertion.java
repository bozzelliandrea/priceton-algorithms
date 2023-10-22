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
}
