package github.algorithms.sorting;

import org.junit.jupiter.api.Test;

class InsertionTest {

    @Test
    void insertionSorting_withInt() {
        SortingAssertion.assertSorted((SortingInt) Insertion::sort);
    }

    @Test
    void insertionSorting_withObjects_usingComparable() {
        SortingAssertion.assertSorted((Sorting) Insertion::sort);
    }
}
