package github.algorithms.module_one;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class HelloGoodbye {
    public static void main(String[] args) {

        String n1 = args[0];
        String n2 = args[1];

        StdOut.println(String.format("Hello %s and %s", n1, n2));
        StdOut.println(String.format("Goodbye %s and %s", n2, n1));
    }
}
