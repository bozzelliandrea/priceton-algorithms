package github.algorithms.symbol_table;

import java.util.NoSuchElementException;

public class BinarySearchTree<K extends Comparable<K>, V> implements SymbolTable<K, V> {

    private BSTNode<K, V> bst;
    private int size;

    public BinarySearchTree() {
        this.bst = null;
        this.size = 0;
    }

    @Override
    public V get(K key) {
        if (key == null)
            throw INVALID_NULL_KEY;

        if (isEmpty())
            throw new NoSuchElementException("Symbol Table is Empty!");

        BSTNode<K, V> node = bst;

        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0)
                node = node.left;
            else if (cmp > 0)
                node = node.right;
            else
                return node.value;
        }

        return null;
    }

    @Override
    public void put(K key, V value) {
        if (key == null)
            throw INVALID_NULL_KEY;

        bst = put(bst, key, value);
        size++;
    }

    private BSTNode<K, V> put(BSTNode<K, V> root, K key, V val) {

        if (root == null)
            return new BSTNode<>(key, val);

        int cmp = key.compareTo(root.key);

        if (cmp < 0)
            root.left = put(root.left, key, val);
        else if (cmp > 0)
            root.right = put(root.right, key, val);
        else
            root.value = val;

        return root;
    }

    public static void main(String[] args) {
        SymbolTable<Integer, String> bst = new BinarySearchTree<>();

        bst.put(1, "lal");
        bst.put(3, "sus");
        bst.put(8, "sooos");
        bst.put(2, "esghere");
        bst.put(5, "faf");

        System.out.println(bst.get(8));
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    private static class BSTNode<K, V> {
        K key;
        V value;
        BSTNode<K, V> left, right;

        public BSTNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
