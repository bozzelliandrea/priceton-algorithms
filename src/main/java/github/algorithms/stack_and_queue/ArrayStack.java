package github.algorithms.stack_and_queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<T> extends Resizable implements Stack<T> {

    private transient T[] data;
    private int n;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        data = (T[]) new Object[INITIAL_CAPACITY];
        n = 0;
    }

    @Override
    public void push(T item) {
        if (n == data.length)
            resize(2 * data.length);

        data[n++] = item;
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");

        T item = data[--n];
        data[n] = null; // force clean by garbage collector

        if (n > 0 && n == data.length / 4)
            resize(data.length / 2);

        return item;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");
        return data[n - 1];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];

        for (int i = 0; i < n; i++) {
            copy[i] = data[i];
        }

        data = copy;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayStackIterator();
    }

    private class ArrayStackIterator implements Iterator<T> {

        int i;

        private ArrayStackIterator() {
            i = n - 1;
        }

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException("Iterator empty!");

            return data[i--];
        }
    }
}
