package github.algorithms.data_structure;

import github.algorithms.symbol_table.BinarySearchTree;
import github.algorithms.symbol_table.LinkedListST;
import github.algorithms.symbol_table.SymbolTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class SymbolTableTest {

    @Test
    void linkedList_st_successTest() {
        final SymbolTable<Integer, String> st = new LinkedListST<>();
        symbolTable_apiAssertions(st);
        symbolTable_exceptionAssertions(st);
    }

    @Test
    void binarySearchTree_st_successTest() {
        final SymbolTable<Integer, String> st = new BinarySearchTree<>();
        symbolTable_apiAssertions(st);
        symbolTable_exceptionAssertions(st);
    }

    private void symbolTable_apiAssertions(SymbolTable<Integer, String> st) {

        Assertions.assertTrue(st.isEmpty());
        Assertions.assertEquals(0, st.size());

        st.put(1, "a");
        st.put(2, "b");

        Assertions.assertEquals(2, st.size());
        Assertions.assertEquals("a", st.get(1));

        st.put(1, "c");

        Assertions.assertEquals(2, st.size());
        Assertions.assertEquals("c", st.get(1));
        Assertions.assertFalse(st.contains(3));

        st.delete(1);

        Assertions.assertEquals(1, st.size());
        Assertions.assertTrue(st.contains(2));
        Assertions.assertFalse(st.isEmpty());


        st.delete(2);

        Assertions.assertEquals(0, st.size());
        Assertions.assertFalse(st.contains(2));
        Assertions.assertTrue(st.isEmpty());
    }

    private void symbolTable_exceptionAssertions(SymbolTable<Integer, String> st) {
        RuntimeException exception = Assertions.assertThrows(NoSuchElementException.class, () -> st.get(20));

        Assertions.assertEquals(SymbolTable.EMPTY.getMessage(), exception.getMessage());

        exception = Assertions.assertThrows(NoSuchElementException.class, () -> st.delete(20));

        Assertions.assertEquals(SymbolTable.EMPTY.getMessage(), exception.getMessage());

        st.put(1, "a");

        exception = Assertions.assertThrows(NoSuchElementException.class, () -> st.get(20));

        Assertions.assertEquals(SymbolTable.KEY_NOT_FOUND(20).getMessage(), exception.getMessage());

        exception = Assertions.assertThrows(NoSuchElementException.class, () -> st.delete(20));

        Assertions.assertEquals(SymbolTable.KEY_NOT_FOUND(20).getMessage(), exception.getMessage());

        st.put(2, "a");

        exception = Assertions.assertThrows(NoSuchElementException.class, () -> st.delete(20));

        Assertions.assertEquals(SymbolTable.KEY_NOT_FOUND(20).getMessage(), exception.getMessage());

        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> st.put(null, "a"));

        Assertions.assertEquals(SymbolTable.INVALID_NULL_KEY.getMessage(), exception.getMessage());
    }
}
