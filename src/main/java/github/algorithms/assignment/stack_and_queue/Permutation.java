package github.algorithms.assignment.stack_and_queue;

import java.util.Scanner;

/**
 * Write a client program Permutation.java that takes an integer k as a command-line argument;
 * reads a sequence of strings from standard input; and prints exactly k of them, uniformly at random.
 * Print each item from the sequence at most once.
 */
public class Permutation {

    public static void main(String[] args) {

        if (args == null || args.length == 0 || args[0].isEmpty() || args[0].isBlank())
            throw new IllegalArgumentException("k needs to be insert!");

        final int k = Integer.parseInt(args[0]);
        final Scanner scanner = new Scanner(System.in);
        final RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>(k);

        while (true) {
            String s = scanner.nextLine();

            if (s.trim().isEmpty())
                break;

            for (String x : s.trim().split(" "))
                if (randomizedQueue.size() < k)
                    randomizedQueue.enqueue(x);
        }

        for (String s : randomizedQueue)
            System.out.println(s);
    }
}
