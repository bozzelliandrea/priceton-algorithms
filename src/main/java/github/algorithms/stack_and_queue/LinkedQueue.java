package github.algorithms.stack_and_queue;

import github.algorithms.commons.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {

    private transient Node<T> first;
    private transient Node<T> last;
    int size;

    public LinkedQueue() {
        first = null;
        last = null;
        size = 0;
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    @Override
    public void enqueue(T item) {
        Node<T> oldLast = last;
        last = new Node<>(item);

        if (isEmpty())
            first = last;
        else
            oldLast.setNext(last);

        size++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     *
     * @return the item on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public T dequeue() {
        if (isEmpty())
            return null;

        final T val = first.getValue();
        first = first.getNext();
        size--;

        if (isEmpty())
            last = null;

        return val;
    }

    @Override
    public T peek() {
        if (isEmpty())
            return null;

        return first.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedQueueIterator(first);
    }

    private class LinkedQueueIterator implements Iterator<T> {

        private Node<T> head;

        LinkedQueueIterator(Node<T> node) {
            this.head = node;
        }

        @Override
        public boolean hasNext() {
            return this.head != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            final T val = this.head.getValue();
            this.head = this.head.getNext();
            return val;
        }
    }
}
