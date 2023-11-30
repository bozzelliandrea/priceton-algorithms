package github.algorithms.stack_and_queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<T> extends Resizable implements Queue<T> {

    transient T[] data;
    int head;
    int tail;
    int size;

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        data = (T[]) new Object[INITIAL_CAPACITY];
        tail = head = size = 0;
    }

    @Override
    public void enqueue(T item) {
        if (size == data.length)
            resize(2 * data.length);

        data[tail] = item;
        size++;
        tail++;
        if (tail == data.length)
            tail = 0;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        T val = data[head];
        data[head] = null; // forcing gc
        head++;
        size--;

        if (head == data.length)
            head = 0;

        if (size > 0 && size == data.length / 4)
            resize(data.length / 2);

        return val;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        return data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            copy[i] = data[(head + i) % data.length];
        }

        head = 0;
        tail = size;
        data = copy;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
