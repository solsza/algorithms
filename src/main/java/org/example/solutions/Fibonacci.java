package org.example.solutions;

public class Fibonacci implements DefaultSolution {

    long getNElementRecursive(int n) {
        if(n == 0 || n == 1) {
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

    public void runDefaultExample() {
        System.out.println(getNElementRecursive(25));
        System.out.println(getNElement(25));
    }


}
