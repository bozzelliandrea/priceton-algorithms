package github.algorithms.stack_and_queue;

import github.algorithms.commons.Node;
import github.algorithms.commons.Pair;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntegerMaxStack implements Stack<Integer> {

    private Node<Pair<Integer, Integer>> head;
    private int size;

    public IntegerMaxStack() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    // O(1)
    @Override
    public void push(Integer item) {

        if (head == null) {
            head = new Node<>(Pair.of(item, item));
        } else {
            final Pair<Integer, Integer> p = (Pair<Integer, Integer>) Pair.of(item);
            if (head.getValue().second() < item)
                p.second(item);
            else
                p.second(head.getValue().second());

            Node<Pair<Integer, Integer>> newNode = new Node<>(p);
            newNode.setNext(head);
            head = newNode;
        }

        size++;
    }

    // O(1)
    @Override
    public Integer pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");

        size--;
        Pair<Integer, Integer> curr = head.getValue();
        head = head.getNext();

        return curr.first();
    }

    @Override
    public Integer peek() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");

        return head.getValue().first();
    }

    public Integer max() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");

        return head.getValue().second();
    }

    @Override
    public Iterator<Integer> iterator() {
        throw new UnsupportedOperationException("Not implemented");
    }
}
