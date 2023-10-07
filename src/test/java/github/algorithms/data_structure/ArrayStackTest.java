package github.algorithms.data_structure;

import github.algorithms.stack_and_queue.ArrayStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Iterator;
import java.util.NoSuchElementException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ArrayStackTest {

    private static final Integer value1 = 1;
    private static final Integer value2 = 2;
    private static final Integer value3 = 3;

    private static final ArrayStack<Integer> stack = new ArrayStack<>();

    @Test
    @Order(1)
    void loadStack() {

        Assertions.assertTrue(stack.isEmpty());

        stack.push(value1);
        Assertions.assertEquals(value1, stack.peek());

        stack.push(value2);
        Assertions.assertEquals(value2, stack.peek());

        stack.push(value3);
        Assertions.assertEquals(value3, stack.peek());

        Assertions.assertFalse(stack.isEmpty());
        Assertions.assertEquals(3, stack.size());
    }

    @Test
    @Order(2)
    void unloadStack() {

        Assertions.assertFalse(stack.isEmpty());
        Assertions.assertEquals(3, stack.size());

        Assertions.assertEquals(value3, stack.pop());

        Assertions.assertEquals(value2, stack.peek());
        Assertions.assertEquals(value2, stack.pop());

        Assertions.assertEquals(value1, stack.peek());
        Assertions.assertFalse(stack.isEmpty());
        Assertions.assertEquals(value1, stack.pop());

        Assertions.assertTrue(stack.isEmpty());
        Assertions.assertEquals(0, stack.size());
    }

    @Test
    @Order(3)
    void pop_emptyStack_shouldThrowException() {

        NoSuchElementException exception = Assertions.assertThrows(NoSuchElementException.class, stack::pop);

        Assertions.assertNotNull(exception);
        Assertions.assertEquals("Stack underflow", exception.getMessage());
    }

    @Test
    @Order(4)
    void peek_emptyStack_shouldThrowException() {

        NoSuchElementException exception = Assertions.assertThrows(NoSuchElementException.class, stack::peek);

        Assertions.assertNotNull(exception);
        Assertions.assertEquals("Stack underflow", exception.getMessage());
    }

    @Test
    void iterator_whileEmpty() {
        final ArrayStack<Integer> stack = new ArrayStack<>();
        final int size = 10;

        for (int i = 1; i <= size; i++)
            stack.push(i);

        Iterator<Integer> iterator = stack.iterator();

        int i = size;
        while (iterator.hasNext()) {
            Assertions.assertEquals(i, iterator.next());
            i--;
        }

        Assertions.assertEquals(0, i);
        Assertions.assertFalse(stack.isEmpty());
        Assertions.assertEquals(size, stack.size());
    }

    @Test
    void iterator_empty_shouldThrowException() {

        NoSuchElementException exception = Assertions.assertThrows(NoSuchElementException.class, () -> {
            new ArrayStack<>().iterator().next();
        });

        Assertions.assertNotNull(exception);
        Assertions.assertEquals("Iterator empty!", exception.getMessage());
    }
}
