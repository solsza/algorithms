package org.example.solutions;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    // n >= 0

    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        for (int i = 1; i <= n - 1; i++) {
            int nextValue = a + b;
            a = b;
            b = nextValue;
        }
        return b;
    }

    Map<Integer, Integer> memo = new HashMap<>();

    public int climbStairsRecursiveSolution(int n) {

        if (n <= 2) {
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = climbStairsRecursiveSolution(n - 1) + climbStairsRecursiveSolution(n - 2);
        memo.put(n, result);
        return result;

    }

    public int runDefaultExample() {
        return climbStairs(3);
    }
}
