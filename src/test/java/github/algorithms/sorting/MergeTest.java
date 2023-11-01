package github.algorithms.sorting;

import org.junit.jupiter.api.Test;

public class MergeTest {

    @Test
    void mergeSort_withInt() {
        SortingAssertion.assertSorted((SortingInt) Merge::sort);
    }

    @Test
    void mergeSort_withObjects_usingComparable() {
        SortingAssertion.assertSorted((Sorting) Merge::sort);
    }

    @Test
    void optimizedMergeSort_withInt() {
        SortingAssertion.assertSorted((SortingInt) OptimizedMerge::sort);
    }

    @Test
    void optimizedMergeSort_withObjects_usingComparable() {
        SortingAssertion.assertSorted((Sorting) OptimizedMerge::sort);
    }

    @Test
    void inPlaceMergeSort_withInt() {
        SortingAssertion.assertSorted((SortingInt) OptimizedMerge::sort);
    }

    @Test
    void inPlaceMergeSort_withObjects_usingComparable() {
        SortingAssertion.assertSorted((Sorting) OptimizedMerge::sort);
    }
}
