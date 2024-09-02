package org.example.solutions.dynamic;

import org.example.solutions.DefaultSolution;

import java.util.HashMap;
import java.util.Map;

public class Tribonacci implements DefaultSolution {

    private int tribonacii(int n) {
        return tribonaciiRecursive(n, new HashMap<Integer, Integer>());
    }

    private int tribonaciiRecursive(int n, Map<Integer, Integer> memo) {
        if (n <= 1) return 0;
        if (n == 2) return 1;

        if (memo.containsKey(n)) return memo.get(n);

        int result = tribonaciiRecursive(n - 1, memo) + tribonaciiRecursive(n - 2, memo) + tribonaciiRecursive(n - 3, memo);
        memo.put(n, result);
        return result;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(tribonacii(37));
    }
}
