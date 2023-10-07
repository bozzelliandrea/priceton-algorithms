package github.algorithms.data_structure;

import github.algorithms.stack_and_queue.LinkedStack;
import github.algorithms.stack_and_queue.Stack;
import org.junit.jupiter.api.*;

import java.util.Iterator;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LinkedStackTest {

    public static Stack<Integer> stack;

    @BeforeAll
    static void beforeAll() {
        stack = new LinkedStack<>();
    }

    @Test
    @Order(1)
    void loadStack() {
        int val = 1;

        while (val <= 10) {
            stack.push(val);

            Assertions.assertEquals(val, stack.size());
            Assertions.assertFalse(stack.isEmpty());
            Assertions.assertEquals(val, stack.peek());
            val++;
        }
        Assertions.assertEquals(10, stack.size());
    }

    @Test
    @Order(2)
    void unloadStack() {

        int val = 10;

        while (val > 0) {
            Assertions.assertEquals(val, stack.peek());
            Assertions.assertEquals(val, stack.size());

            Assertions.assertEquals(val, stack.pop());
            Assertions.assertEquals(val - 1, stack.size());

            val--;
        }
        Assertions.assertEquals(0, stack.size());
        Assertions.assertTrue(stack.isEmpty());
        Assertions.assertEquals(0, val);

        // check after empty stack
        Assertions.assertNull(stack.pop());
        Assertions.assertNull(stack.peek());
    }

    @Test
    void iterator_whileEmpty() {
        final Stack<Integer> stack = new LinkedStack<>();


        for(int i = 1; i <= 10; i++)
            stack.push(i);

        Iterator<Integer> iterator = stack.iterator();

        int i = 10;
        while (iterator.hasNext()) {
            Assertions.assertEquals(i, iterator.next());
            i--;
        }

        Assertions.assertEquals(0, i);
    }
}
