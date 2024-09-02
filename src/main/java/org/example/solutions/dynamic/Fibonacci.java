package org.example.solutions.dynamic;

import org.example.solutions.DefaultSolution;

import java.util.HashMap;

public class Fibonacci implements DefaultSolution {

    long getNElementRecursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return getNElementRecursive(n - 1) + getNElementRecursive(n - 2);
    }


    long getNElement(int n) {
        if (n <= 1) {
            return n;
        }
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    int fib(int n) {
        return fibRecursive(n, new HashMap<Integer, Integer>());
    }

    int fibRecursive(int n, HashMap<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int result = fibRecursive(n - 1, memo) + fibRecursive(n - 2, memo);
        memo.put(n, result);
        return result;
    }

    public void runDefaultExample() {
        System.out.println(getNElementRecursive(25));
        System.out.println(getNElement(25));
    }


}
