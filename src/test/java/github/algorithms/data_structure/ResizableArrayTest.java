package github.algorithms.data_structure;

import github.algorithms.stack_and_queue.ResizableArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Arrays;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ResizableArrayTest {

    private static final Integer value1 = 1;
    private static final Integer value2 = 2;
    private static final Integer value3 = 3;

    private static final ResizableArray<Integer> RESIZABLE_ARRAY = new ResizableArray<>();

    @Test
    @Order(1)
    void loadArray_andGet() {
        Assertions.assertTrue(RESIZABLE_ARRAY.isEmpty());

        RESIZABLE_ARRAY.add(value1);
        Assertions.assertEquals(value1, RESIZABLE_ARRAY.get(RESIZABLE_ARRAY.size() - 1));

        RESIZABLE_ARRAY.add(value2);
        Assertions.assertEquals(value2, RESIZABLE_ARRAY.get(RESIZABLE_ARRAY.size() - 1));

        RESIZABLE_ARRAY.add(value3);
        Assertions.assertEquals(value3, RESIZABLE_ARRAY.get(RESIZABLE_ARRAY.size() - 1));

        Assertions.assertFalse(RESIZABLE_ARRAY.isEmpty());
        Assertions.assertEquals(3, RESIZABLE_ARRAY.size());

        Assertions.assertEquals(
                Arrays.toString(new Integer[]{1, 2, 3, null, null, null, null, null}),
                RESIZABLE_ARRAY.toString()
        );
    }

    @Test
    @Order(2)
    void unloadArray() {
        Assertions.assertFalse(RESIZABLE_ARRAY.isEmpty());
        Assertions.assertEquals(3, RESIZABLE_ARRAY.size());

        Assertions.assertEquals(value1, RESIZABLE_ARRAY.remove(0));

        Assertions.assertEquals(
                Arrays.toString(new Integer[]{2, 3, null, null}),
                RESIZABLE_ARRAY.toString()
        );

        Assertions.assertEquals(value3, RESIZABLE_ARRAY.remove(1));

        Assertions.assertEquals(
                Arrays.toString(new Integer[]{2, null}),
                RESIZABLE_ARRAY.toString()
        );


        Assertions.assertFalse(RESIZABLE_ARRAY.isEmpty());
        Assertions.assertEquals(1, RESIZABLE_ARRAY.size());
    }

    @Test
    @Order(3)
    void getWrongIndex_shouldThrowException() {

        ArrayIndexOutOfBoundsException exception = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> RESIZABLE_ARRAY.get(1));

        Assertions.assertNotNull(exception);
        Assertions.assertEquals("Index to high", exception.getMessage());
    }

    @Test
    @Order(4)
    void removeZeroIndexElement() {

        Assertions.assertEquals(value2, RESIZABLE_ARRAY.remove(0));

        Assertions.assertTrue(RESIZABLE_ARRAY.isEmpty());
        Assertions.assertEquals(0, RESIZABLE_ARRAY.size());
    }
}
