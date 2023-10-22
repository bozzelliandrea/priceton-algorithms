package github.algorithms.stack_and_queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ResizableArray<T> extends Resizable implements Collection {

    transient T[] data;
    int idx;
    int size;

    @SuppressWarnings("unchecked")
    public ResizableArray() {
        data = (T[]) new Object[INITIAL_CAPACITY];
        idx = 0;
        size = 0;
    }

    public void add(T item) {
        data[idx] = item;
        idx++;
        size++;

        if (size == data.length)
            resize(data.length * 2);
    }

    public T get(int idx) {
        if (idx > this.idx - 1)
            throw new ArrayIndexOutOfBoundsException("Index to high");

        return data[idx];
    }

    public T remove(int idx) {
        if (isEmpty())
            throw new NoSuchElementException("Array empty");

        if (idx > this.idx - 1)
            throw new ArrayIndexOutOfBoundsException("Index to high");

        T e = data[idx];
        data[idx] = null;

        size--;
        if (size > 0 && size == data.length / 4)
            resize(data.length / 2);
        else shift_left(++idx);

        if (isEmpty())
            this.idx = 0;

        return e;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    @Override
    protected void resize(int capacity) {
        T[] tmp = (T[]) new Object[capacity];

        for (int i = 0, j = 0; i < data.length; i++) {
            if (data[i] != null) {
                tmp[j] = data[i];
                j++;
                idx = j;
            }
        }

        data = tmp;
    }

    private void shift_left(int start) {
        while (data[start] != null) {
            data[start - 1] = data[start];
            data[start] = null;
            start++;
            idx = start;
        }
    }
}
