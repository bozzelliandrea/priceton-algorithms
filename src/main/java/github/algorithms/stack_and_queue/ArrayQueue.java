package github.algorithms.stack_and_queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueue<T> extends Resizable implements Queue<T> {

    T[] data;
    int head;
    int tail;
    int size;

    public static void main(String[] args) {
        ArrayQueue<Integer> a = new ArrayQueue<>();

        a.enqueue(1);
        a.enqueue(2);
        a.enqueue(3);

        a.dequeue();
        a.dequeue();
        a.dequeue();

        a.enqueue(4);
        a.enqueue(5);
        a.enqueue(6);

        //a.resize(10);

        a.enqueue(41);
        a.enqueue(51);
        a.enqueue(61);

        a.enqueue(42);
        a.enqueue(52);
        a.enqueue(62);

        a.enqueue(43);
        a.enqueue(53);
        a.enqueue(63);

        a.enqueue(44);
        a.enqueue(54);
        a.enqueue(64);

        System.out.println(Arrays.toString(a.data));
        System.out.println("of size: " + a.size);

    }

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        data = (T[]) new Object[INITIAL_CAPACITY];
        tail = head = size = 0;
    }

    @Override
    public void enqueue(T item) {
        data[tail] = item;
        size++;

        if (size == data.length)
            resize(2 * data.length);

        tail++;
        if (tail == data.length && head > 0)
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
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        int copyTail = tail;

        int i = head, j = 0;

        while (i < data.length && data[i] != null) {
            copy[j] = data[i];
            data[i] = null;
            copyTail = j;
            i++;
            j++;
        }

        if (tail < head) {
            i = 0;
            while (i < tail) {
                copy[j] = data[i];
                data[i] = null;
                copyTail = j;
                i++;
                j++;
            }
        }

        head = 0;
        tail = copyTail + 1;
        data = copy;
    }

}
