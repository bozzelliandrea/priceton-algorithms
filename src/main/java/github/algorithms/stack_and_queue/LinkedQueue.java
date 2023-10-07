package github.algorithms.stack_and_queue;

public class LinkedQueue<T> implements Queue<T> {

    private Node<T> first;
    private Node<T> last;
    int size;

    public LinkedQueue() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void enqueue(T item) {
        Node<T> oldLast = last;
        Node<T> newLast = new Node<>(item);
        size++;

        if (isEmpty())
            first = newLast;
        else
            oldLast.setNext(newLast);

        last = newLast;
    }

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
    public boolean isEmpty() {
        return first == null;
    }
}
