package github.algorithms.assignment.stack_and_queue;

import github.algorithms.stack_and_queue.DoubleNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Dequeue. A double-ended queue or deque (pronounced “deck”) is a generalization of a stack and a queue that supports
 * adding and removing items from either the front or the back of the data structure.
 * Create a generic data type Deque.
 * <br/><br/>
 * <b>Performance requirements.</b>  Your deque implementation must support each deque operation (including construction)
 * in <b>constant</b> worst-case time. A deque containing n items must use at most 48n + 192 bytes of memory.
 * Additionally, your iterator implementation must support each operation (including construction) in constant worst-case time.
 */
public class Deque<T> implements Iterable<T> {

    private DoubleNode<T> first;
    private DoubleNode<T> last;
    private int size;

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the T to the front
    public void addFirst(T item) {
        if (item == null)
            throw new IllegalArgumentException("Item cannot be null!");

        DoubleNode<T> oldFirst = first;
        DoubleNode<T> newFirst = new DoubleNode<>(item);
        newFirst.setNext(oldFirst);

        if (isEmpty())
            last = newFirst;
        else
            oldFirst.setPrev(newFirst);

        size++;
        first = newFirst;
    }

    // add the T to the back
    public void addLast(T item) {
        if (item == null)
            throw new IllegalArgumentException("Item cannot be null!");

        DoubleNode<T> oldTail = last;
        DoubleNode<T> newTail = new DoubleNode<>(item);
        newTail.setPrev(oldTail);

        if (isEmpty())
            first = newTail;
        else
            oldTail.setNext(newTail);

        size++;
        last = newTail;
    }

    // remove and return the T from the front
    public T removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("Empty deque!");

        final T v = first.getValue();
        first = first.getNext();
        size--;

        if (isEmpty())
            last = null;
        else
            first.setPrev(null);

        return v;
    }

    // remove and return the T from the back
    public T removeLast() {
        if (isEmpty())
            throw new NoSuchElementException("Empty deque!");

        final T v = last.getValue();
        last = last.getPrev();
        size--;

        if (isEmpty())
            first = null;
        else
            last.setNext(null);

        return v;
    }

    // return an iterator over items in order from front to back
    @Override
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(7);

        System.out.println(deque.removeFirst());

        System.out.println(deque.removeLast());

        System.out.println(deque);
    }

    private class DequeIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            if (isEmpty())
                throw new NoSuchElementException("Empty deque!");

            return null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("DequeIterator doesn't support remove operation");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        DoubleNode<T> head = first;
        while (head != null) {
            sb.append(head.getValue()).append(',').append(' ');
            head = head.getNext();
        }
        sb.deleteCharAt(sb.length() - 2).append("]");
        return sb.toString();
    }
}
