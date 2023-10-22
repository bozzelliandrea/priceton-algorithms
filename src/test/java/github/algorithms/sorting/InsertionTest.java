package github.algorithms.sorting;

import org.junit.jupiter.api.Test;

class InsertionTest {

    @Test
    void insertionSorting_withInt() {

        SortingAssertion.assertSorted(Insertion::sort);
    }
}
