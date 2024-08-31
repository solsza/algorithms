package org.example.solutions.dynamic;

import org.example.solutions.DefaultSolution;

import java.util.HashMap;

public class PerfectSquares implements DefaultSolution {

    private int summingSquares(int n) {
        return (int) summingSquares(n, new HashMap<>());
    }

    private double summingSquares(int n, HashMap<Integer, Double> memo) {
        if (n < 0) return Double.POSITIVE_INFINITY;
        if (n == 0) return 0.;
        if (memo.containsKey(n)) return memo.get(n);
        Double minSquares = Double.POSITIVE_INFINITY;
        for (int i = 1; i <= Math.sqrt(n); i += 1) {
            int square = i * i;
            double numSquares = 1 + summingSquares(n - square, memo);
            if (numSquares < minSquares) {
                minSquares = numSquares;
            }
        }
        memo.put(n, minSquares);
        return minSquares;
    }


    @Override
    public void runDefaultExample() {

    }
}
