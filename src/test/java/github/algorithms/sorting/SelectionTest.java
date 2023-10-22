package github.algorithms.sorting;

import org.junit.jupiter.api.Test;

public class SelectionTest {

    @Test
    void selectionSorting_withInt() {

        SortingAssertion.assertSorted(Selection::sort);
    }
}
