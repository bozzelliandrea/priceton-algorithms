package github.algorithms.stack_and_queue;

public class LinkedQueue<T> implements Queue<T> {

    private transient Node<T> first;
    private transient Node<T> last;
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

        if (isEmpty())
            first = newLast;
        else
            oldLast.setNext(newLast);

        size++;
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
}
