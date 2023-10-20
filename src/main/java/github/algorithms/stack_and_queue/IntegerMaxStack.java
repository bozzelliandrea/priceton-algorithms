package github.algorithms.stack_and_queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntegerMaxStack implements Stack<Integer> {

    private Node<Integer> head;
    private int size;
    private Integer max;

    public IntegerMaxStack() {
        head = null;
        size = 0;
        max = Integer.MIN_VALUE;
    }

    @Override
    public int size() {
        return size;
    }

    // O(1)
    @Override
    public void push(Integer item) {

        if (head == null) {
            head = new Node<>(item, null);
            max = item;
        } else {
            if (max < item)
                max = item;

            Node<Integer> newNode = new Node<>(item);
            newNode.setNext(head);
            head = newNode;
        }

        size++;
    }

    // O(n) caused by max calc function
    @Override
    public Integer pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");

        size--;
        Integer curr = head.getValue();
        head = head.getNext();
        _calculateMax();

        return curr;
    }

    @Override
    public Integer peek() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");

        return head.getValue();
    }

    public Integer max() {
        return max;
    }

    private void _calculateMax() {
        if (isEmpty())
            max = null;
        else
            max = Integer.MIN_VALUE;

        Node<Integer> curr = head;

        while (curr != null) {
            if (curr.getValue() > max)
                max = curr.getValue();

            curr = curr.getNext();
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        throw new UnsupportedOperationException("Not implemented");
    }
}
