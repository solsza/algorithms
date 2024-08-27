package org.example.solutions;

public class Factorial implements DefaultSolution {

    private long factorial(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    @Override
    public void runDefaultExample() {
        System.out.println(factorial(3));
        System.out.println(factorial(6));
        System.out.println(factorial(18));
        System.out.println(factorial(1));
        System.out.println(factorial(0));
    }
}
