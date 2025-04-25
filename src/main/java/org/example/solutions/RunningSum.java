package org.example.solutions;

import java.util.ArrayList;
import java.util.List;

public class RunningSum implements DefaultSolution {

    public static List<Integer> runningSum(List<Integer> numbers) {
        int total = 0;
        List<Integer> result = new ArrayList<>();
        for (int num : numbers) {
            total += num;
            result.add(total);
        }
        return result;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(runningSum(List.of(4, 2, 1, 6, 3, 6))); // -> [ 4, 6, 7, 13, 16, 22 ]
        System.out.println(runningSum(List.of(10, 5, -2, 1, 1))); // -> [ 4, 6, 7, 13, 16, 22 ]
        System.out.println(runningSum(List.of(12, 88, 0, -50, 30, 2))); // -> [ 4, 6, 7, 13, 16, 22 ]
    }
}
