package github.algorithms.assignment.symbol_table;

import java.util.Stack;

/**
 * Check if binary tree is a BST.
 * Given a binary tree where each Node contains a Key,
 * determine whether it is a binary search tree. Use extra space proportional to the height of the tree.
 */
public class CheckBalancedBinaryTree {

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(5, new Node<>(3, new Node<>(2), new Node<>(4)), new Node<>(6));

        // expect true
        System.out.println(checkBalanced(root));

        Node<Integer> root2 = new Node<>(5, new Node<>(3, new Node<>(88), new Node<>(4)), new Node<>(6));

        // expect false
        System.out.println(checkBalanced(root2));

        // expect true
        System.out.println(checkBalanced(new Node<>(9)));
    }

    public static boolean checkBalanced(Node<Integer> root) {

        // balanced if null or if only root node has value
        if (root == null || (root.left == null && root.right == null))
            return true;

        Stack<Node<Integer>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node<Integer> node = stack.pop();

            if ((node.right != null && node.val > node.right.val)
                    || (node.left != null && node.left.val > node.val))
                return false;

            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }

        return true;
    }

    public static class Node<K> {
        Node<K> left;
        Node<K> right;
        K val;

        public Node(K val) {
            this.val = val;
        }

        public Node(K val, Node<K> left, Node<K> right) {
            this(val);
            this.left = left;
            this.right = right;
        }
    }
}
