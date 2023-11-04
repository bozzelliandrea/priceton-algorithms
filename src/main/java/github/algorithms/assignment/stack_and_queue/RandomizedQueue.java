package github.algorithms.assignment.stack_and_queue;

import github.algorithms.stack_and_queue.Collection;
import github.algorithms.stack_and_queue.Queue;
import github.algorithms.stack_and_queue.Resizable;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

@SuppressWarnings("unchecked")
public class RandomizedQueue<T> extends Resizable implements Queue<T>, Iterable<T> {

    private int size;
    private T[] data;

    private final Random random;

    public RandomizedQueue() {
        size = 0;
        data = (T[]) new Object[INITIAL_CAPACITY];
        random = new Random();
    }

    @Override
    public int size() {
        return size;
    }

    // add element at the end and then swap with a random element in range 0 to size - 1
    @Override
    public void enqueue(T item) {
        if (size == data.length)
            resize(data.length * 2);

        data[size] = item;
        if (size > 0)
            Collection.swap(data, random.nextInt(size), size);
        size++;
    }

    // last element (LIFO like) on the array (avoid shuffle)
    @Override
    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Empty deque!");

        if (size > 0 && size == (data.length / 4))
            resize(data.length / 2);

        T val = data[--size];
        data[size] = null;

        return val;
    }

    // random element in range 0 to size
    @Override
    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException("Empty deque!");

        return data[random.nextInt(size)];
    }

    // for this exercise the standard queue peek api is called sample
    public T sample() {
        return peek();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    protected void resize(int capacity) {
        T[] objs = (T[]) new Object[capacity];

        for (int i = 0; i < capacity; i++) {
            objs[i] = data[i];
            data[i] = null;
        }

        data = objs;
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
