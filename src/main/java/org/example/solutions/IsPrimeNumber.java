package org.example.solutions;

public class IsPrimeNumber implements DefaultSolution {

    boolean isPrime(int number) {
        if (number <= 2) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(isPrime(2017));
        System.out.println(isPrime(713));
    }
}
