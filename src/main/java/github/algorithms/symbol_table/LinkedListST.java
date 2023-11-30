package github.algorithms.symbol_table;

import github.algorithms.commons.Node;
import github.algorithms.commons.Pair;
import github.algorithms.stack_and_queue.LinkedQueue;
import github.algorithms.stack_and_queue.LinkedStack;
import github.algorithms.stack_and_queue.Queue;
import github.algorithms.stack_and_queue.Stack;

import static github.algorithms.symbol_table.SymbolTable.KEY_NOT_FOUND;

public class LinkedListST<K, V> implements SymbolTable<K, V> {

    private Node<Pair<K, V>> data;
    private int size;

    public LinkedListST() {
        size = 0;
        data = null;
    }

    @Override
    public V get(K key) {
        if (key == null)
            throw INVALID_NULL_KEY;

        if (isEmpty())
            throw EMPTY;

        Node<Pair<K, V>> head = data;

        while (head != null) {
            if (head.getValue().first().equals(key))
                return head.getValue().second();

            head = head.getNext();
        }

        throw KEY_NOT_FOUND(key);
    }

    @Override
    public void put(K key, V value) {
        if (key == null)
            throw INVALID_NULL_KEY;

        if (data == null) {
            data = new Node<>(Pair.of(key, value));
            size++;
            return;
        }

        Node<Pair<K, V>> head = data;

        while (head != null) {
            if (head.getValue().first().equals(key)) {
                head.getValue().second(value);
                return;
            }

            head = head.getNext();
        }

        data = new Node<>(Pair.of(key, value), data);
        size++;
    }

    @Override
    public void delete(K key) {
        if (isEmpty())
            throw EMPTY;

        Node<Pair<K, V>> head = data;

        if (size == 1)
            if (head.getValue().first().equals(key)) {
                data = null;
                size = 0;
                return;
            } else throw KEY_NOT_FOUND(key);

        if (head.getValue().first().equals(key)) {
            data = data.getNext();
            size--;
            return;
        }

        while (head != null) {
            if (head.getNext() != null
                    && head.getNext().getValue().first().equals(key)) {
                head.setNext(head.getNext().getNext());
                size--;
                return;
            }

            head = head.getNext();
        }

        throw KEY_NOT_FOUND(key);
    }

    @Override
    public boolean contains(K key) {
        if (isEmpty())
            return false;

        Node<Pair<K, V>> head = data;
        while (head != null) {
            if (head.getValue().first().equals(key))
                return true;

            head = head.getNext();
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterable<K> keys() {
        final Queue<K> queue = new LinkedQueue<>();
        Node<Pair<K, V>> head = data;

        while (head != null) {
            queue.enqueue(head.getValue().first());
            head = head.getNext();
        }

        return queue;
    }

    public static void main(String[] args) {
        SymbolTable<Integer, String> bst = new LinkedListST<>();

        bst.put(1, "lal");
        bst.put(3, "sus");
        bst.put(8, "sooos");
        bst.put(2, "esghere");
        bst.put(5, "faf");

        for (Integer i : bst.keys()) {
            System.out.println(i);
        }

        System.out.println("++++++++++++++++++++");

        Stack<Integer> stack = new LinkedStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);


        for (Integer i : stack) {
            System.out.println(i);
        }


        Queue<Integer> q = new LinkedQueue<>();
        System.out.println("++++++++++++++++++++");
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);


        System.out.println(q.dequeue());

        for (Integer i : q) {
            System.out.println(i);
        }
    }
}
