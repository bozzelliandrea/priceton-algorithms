package github.algorithms.data_structure;

import github.algorithms.stack_and_queue.LinkedQueue;
import github.algorithms.stack_and_queue.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LinkedQueueTest {

    public static Queue<Integer> queue;

    @BeforeAll
    static void beforeAll() {
        queue = new LinkedQueue<>();
    }

    @Test
    @Order(1)
    void loadQueue() {
        int val = 1;

        while (val <= 10) {
            queue.enqueue(val);

            Assertions.assertEquals(val, queue.size());
            Assertions.assertFalse(queue.isEmpty());
            Assertions.assertEquals(1, queue.peek());
            val++;
        }
        Assertions.assertEquals(10, queue.size());
    }

    @Test
    @Order(2)
    void unloadQueue() {

        int val = 1;
        int expectedSize = 10;
        Assertions.assertEquals(expectedSize, queue.size());

        while (val <= 10) {
            Assertions.assertEquals(val, queue.peek());
            Assertions.assertEquals(expectedSize, queue.size());
            Assertions.assertEquals(val, queue.dequeue());
            Assertions.assertEquals(expectedSize - 1, queue.size());
            expectedSize--;
            val++;
        }
        Assertions.assertEquals(0, queue.size());
        Assertions.assertTrue(queue.isEmpty());
        Assertions.assertEquals(0, expectedSize);

        // check after empty stack
        Assertions.assertNull(queue.dequeue());
        Assertions.assertNull(queue.peek());
    }

}
