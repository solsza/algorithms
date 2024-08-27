package org.example.solutions;

public class CountDown implements DefaultSolution {

    private void countDown(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        countDown(n - 1);
    }

    @Override
    public void runDefaultExample() {
        countDown(100);
    }
}
