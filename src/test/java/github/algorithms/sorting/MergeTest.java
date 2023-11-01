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
    void inPlaceMergeSort_withInt() {
        SortingAssertion.assertSorted((SortingInt) InPlaceMerge::sort);
    }

    @Test
    void inPlaceMergeSort_withObjects_usingComparable() {
        SortingAssertion.assertSorted((Sorting) InPlaceMerge::sort);
    }

    //todo: all sorting algorithms in decreasing order
}
