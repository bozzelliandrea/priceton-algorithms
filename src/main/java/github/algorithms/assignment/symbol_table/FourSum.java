package github.algorithms.assignment.symbol_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array a[] of n integers, the 4-SUM problem is to determine if there exist distinct indices i, j, k, and l
 * such that a[i] + a[j] = a[k] + a[l].
 * Design an algorithm for the 4-SUM problem that takes time proportional to n^2 (under suitable technical assumptions).
 */
public class FourSum {

    static boolean algorithm(int[] input) {

        if (input == null || input.length < 4)
            return false;

        int[] ans = new int[4];


        int n = input.length;
        Map<Integer, List<int[]>> map = new HashMap<>();

        // Step 1: Calculate pair sums and store them in the HashMap
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = input[i] + input[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<>());
                }
                map.get(sum).add(new int[]{i, j});
            }
        }

        // Step 2: Check if inside the map there are key with value of size > 1
        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet())
            if (entry.getValue().size() > 1)
                return true;

        return false;
    }

    public static void main(String[] args) {
        int[] t1 = {0, 1, 3, 4, 5, -1, 2}; // 0,1 and -1,-2

        System.out.println(algorithm(t1));

        System.out.println(algorithm(new int[]{0, 1, 3, 4, 5})); // 1,3 and 4,0

        System.out.println(algorithm(new int[]{1, 3, 4, 5}));

        System.out.println(algorithm(new int[]{1, 3}));
    }
}
