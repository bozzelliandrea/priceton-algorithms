package github.algorithms.sorting;

import org.junit.jupiter.api.Test;

public class SelectionTest {

    @Test
    void selectionSorting_withInt() {
        SortingAssertion.assertSorted((SortingInt) Selection::sort);
    }

    @Test
    void selectionSorting_withObjects_usingComparable() {
        SortingAssertion.assertSorted((Sorting) Insertion::sort);
    }
}
