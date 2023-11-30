package github.algorithms.stack_and_queue;


import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

//double stack based queue
public class DoubleStackQueue<T extends Serializable> implements Queue<T> {

    private final transient Stack<T> inbox;
    private final transient Stack<T> outbox;

    public DoubleStackQueue() {
        inbox = new LinkedStack<>();
        outbox = new LinkedStack<>();
    }

    @Override
    public int size() {
        return inbox.size() + outbox.size();
    }

    @Override
    public void enqueue(T item) {
        inbox.push(item);
    }

    @Override
    public T dequeue() {
        _validate_and_reverse();

        return outbox.pop();
    }

    @Override
    public T peek() {
        _validate_and_reverse();

        return outbox.peek();
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        int size = size();

        T[] arr = (T[]) new Serializable[size];

        for (int i = 0; i < size; i++)
            arr[i] = this.dequeue();

        for (int i = 0; i < size; i++) {
            this.enqueue(arr[i]);
        }

        return arr;
    }

    private void _validate_and_reverse() {
        if (inbox.isEmpty() && outbox.isEmpty())
            throw new NoSuchElementException("Queue underflow");

        if (!inbox.isEmpty() && outbox.isEmpty())
            while (!inbox.isEmpty())
                outbox.push(inbox.pop());
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
