package github.algorithms.priority_and_heap;

import github.algorithms.commons.Node;
import github.algorithms.stack_and_queue.Queue;

import java.util.Iterator;

public class LinkedListPriorityQueue<T> implements Queue<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public LinkedListPriorityQueue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void enqueue(T item) {

    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
