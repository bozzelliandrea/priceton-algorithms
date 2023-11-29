package github.algorithms.symbol_table;

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
        return size(bst);
    }

    private int size(BSTNode<K, V> node) {
        return node == null ? 0 : node.count;
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
