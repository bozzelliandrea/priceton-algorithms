package github.algorithms.symbol_table;

import github.algorithms.stack_and_queue.LinkedQueue;
import github.algorithms.stack_and_queue.Queue;

import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree<K extends Comparable<K>, V> implements SymbolTable<K, V> {

    private BSTNode<K, V> bst;

    public BinarySearchTree() {
        this.bst = null;
    }

    @Override
    public V get(K key) {
        if (key == null)
            throw INVALID_NULL_KEY;

        if (isEmpty())
            throw EMPTY;

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
    }

    private BSTNode<K, V> put(BSTNode<K, V> root, K key, V val) {

        if (root == null)
            return new BSTNode<>(key, val, 1);

        int cmp = key.compareTo(root.key);

        if (cmp < 0)
            root.left = put(root.left, key, val);
        else if (cmp > 0)
            root.right = put(root.right, key, val);
        else
            root.value = val;

        root.count = 1 + size(root.left) + size(root.right);
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();

        bst.put(1, "lal");
        bst.put(3, "sus");
        bst.put(8, "sooos");
        bst.put(2, "esghere");
        bst.put(5, "faf");

        System.out.println("Min:" + bst.min());
        System.out.println("Max:" + bst.max());
        System.out.println("Size:" + bst.size());

        System.out.println(bst.contains(8));
        System.out.println(bst.contains(88));

        System.out.println(bst.rank(3));


        System.out.println("++++++++++++++++++++");
        for (Integer k : bst.levelOrderTraversal()) System.out.println(k);

        System.out.println("++++++++++++++++++++");
        for (Integer k : bst.keys()) System.out.println(k);

        System.out.println(bst.contains(8));


    }

    @Override
    public void delete(K key) {

    }

    @Override
    public boolean contains(K key) {
        if (isEmpty())
            return false;

        BSTNode<K, V> root = bst;

        while (root != null) {
            int cmp = key.compareTo(root.key);
            if (cmp < 0)
                root = root.left;
            else if (cmp > 0)
                root = root.right;
            else
                return true;
        }

        return false;
    }

    @Override
    public int size() {
        return size(bst);
    }

    private int size(BSTNode<K, V> node) {
        return node == null ? 0 : node.count;
    }

    @Override
    public Iterable<K> keys() {
        Queue<K> queue = new LinkedQueue<>();
        inorderTraversal(bst, queue);
        return queue;
    }

    private void inorderTraversal(BSTNode<K, V> node, Queue<K> queue) {
        if (node == null)
            return;

        inorderTraversal(node.left, queue);
        queue.enqueue(node.key);
        inorderTraversal(node.right, queue);
    }

    /**
     * Level order traversal (BFS)
     *
     * @return {@link Iterable} with all keys in order level
     */
    public Iterable<K> levelOrderTraversal() {
        if (isEmpty())
            return new LinkedList<>();

        Queue<BSTNode<K, V>> queue = new LinkedQueue<>();
        List<K> list = new LinkedList<>();

        queue.enqueue(bst);
        while (!queue.isEmpty()) {
            BSTNode<K, V> node = queue.dequeue();

            list.add(node.key);

            if (node.left != null)
                queue.enqueue(node.left);
            if (node.right != null)
                queue.enqueue(node.right);
        }

        return list;
    }

    public K min() {
        if (isEmpty())
            throw EMPTY;

        BSTNode<K, V> curr = bst;
        K min = null;

        while (curr != null) {
            min = curr.key;
            curr = curr.left;
        }

        return min;
    }

    public K max() {
        if (isEmpty())
            throw EMPTY;

        BSTNode<K, V> curr = bst;
        K max = null;

        while (curr != null) {
            max = curr.key;
            curr = curr.right;
        }

        return max;
    }

    /**
     * count how many keys in the bst are less than input key
     *
     * @param key to rank
     * @return count of node.key < key
     */
    public int rank(K key) {
        return rank(bst, key);
    }

    private int rank(BSTNode<K, V> root, K key) {
        if (root == null)
            return 0;

        int cmp = key.compareTo(root.key);

        if (cmp < 0)
            return rank(root.left, key);
        else if (cmp > 0)
            return 1 + size(root.left) + rank(root.right, key);
        else
            return size(root.left);
    }

    private static class BSTNode<K, V> {
        K key;
        V value;
        BSTNode<K, V> left, right;
        int count;

        public BSTNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(K key, V value, int count) {
            this(key, value);
            this.count = count;
        }
    }
}
