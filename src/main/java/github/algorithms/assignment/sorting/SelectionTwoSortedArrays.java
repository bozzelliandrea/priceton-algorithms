package github.algorithms.assignment.sorting;

/**
 * Given two sorted array a and b of length n1 and n2, and an integer k
 * design an algorithm to find a key of rank k, the worst case running time should be O(log n)
 * </br></br>
 * k >= 0 && k < n1 + n2
 */
public class SelectionTwoSortedArrays {

    /**
     * Brute force approach:
     * initialize two pointer i and j, increment each one running through the arrays,
     * when the sum of the 2 pointer is equal to k return the value of the last moved index.
     *
     * @param k position wanted
     * @return the value at index k or -1 if the input parameters are not valid.
     */
    public static int select(int[] a, int[] b, int k) {
        if (a == null || b == null || k > a.length + b.length)
            return -1;

        int i = 0, j = 0;
        int prev = -1;

        while ((i + j) < k) {
            if (j >= b.length || (i < a.length && a[i] <= b[j])) {
                prev = a[i];
                i++;
            } else {
                prev = b[j];
                j++;
            }
        }

        return prev;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3};
        int[] b = {1, 2, 3, 4, 5};

        System.out.println(select(a, b, 1));
        System.out.println(select(a, b, 2));
        System.out.println(select(a, b, 3));
        System.out.println(select(a, b, 4));
        System.out.println(select(a, b, 5));
        System.out.println(select(a, b, 6));
        System.out.println(select(a, b, 7));
        System.out.println(select(a, b, 8));
        System.out.println(select(a, b, 9));
    }
}
