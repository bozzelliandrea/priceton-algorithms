package github.algorithms.stack_and_queue;

import github.algorithms.commons.Node;

import java.io.Serializable;
import java.util.Iterator;

public class LinkedStack<T extends Serializable> implements Stack<T> {

    private transient Node<T> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public void push(T item) {
        size++;

        if (top == null) {
            top = new Node<>(item, null);
            return;
        }
        top = new Node<>(item, top);
    }

    @Override
    public T pop() {
        if (isEmpty())
            return null;

        final T n = top.getValue();
        top = top.getNext();
        size--;
        return n;
    }

    @Override
    public T peek() {
        return isEmpty() ? null : top.getValue();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedStackIterator<>(this.top);
    }

    private static class LinkedStackIterator<T> implements Iterator<T> {

        private Node<T> top;

        public LinkedStackIterator(Node<T> t) {
            this.top = t;
        }

        @Override
        public boolean hasNext() {
            return top != null;
        }

        @Override
        public T next() {
            final T v = top.getValue();
            top = top.getNext();
            return v;
        }

        @Override
        public void remove() {
            top = top.getNext();
        }
    }
}
