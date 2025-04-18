package org.example.solutions;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz implements DefaultSolution {

    public static List<Object> fizzBuzz(int n) {
        List<Object> result = new ArrayList<>();

        for (int i = 1; i <= n; i += 1) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("fizzbuzz");
            } else if (i % 3 == 0 ) {
                result.add("fizz");
            } else if (i % 5 == 0) {
                result.add("buzz");
            } else {
                result.add(i);
            }
        }

        return result;
    }

    public void runDefaultExample() {
        System.out.println(fizzBuzz(11));
    }
}
