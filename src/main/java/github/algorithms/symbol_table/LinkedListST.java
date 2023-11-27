package github.algorithms.symbol_table;

import github.algorithms.commons.Node;
import github.algorithms.commons.Pair;

import java.util.NoSuchElementException;

public class LinkedListST<K, V> implements SymbolTable<K, V> {

    private Node<Pair<K, V>> data;
    private int size;

    public LinkedListST() {
        size = 0;
        data = null;
    }

    @Override
    public V get(K key) {
        if (isEmpty())
            throw new NoSuchElementException("Symbol Table is Empty!");

        Node<Pair<K, V>> head = data;

        while (head != null) {
            if (head.getValue().first().equals(key))
                return head.getValue().second();

            head = head.getNext();
        }

        throw new NoSuchElementException("Key " + key + " not found");
    }

    @Override
    public void put(K key, V value) {
        if (key == null)
            throw new IllegalArgumentException("Null key value is invalid!");

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
            throw new NoSuchElementException("Symbol Table is Empty!");

        Node<Pair<K, V>> head = data;

        if (size == 1)
            if (head.getValue().first().equals(key)) {
                data = null;
                size = 0;
                return;
            } else throw new NoSuchElementException("Key " + key + " not found");

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

        throw new NoSuchElementException("Key " + key + " not found");
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
}
