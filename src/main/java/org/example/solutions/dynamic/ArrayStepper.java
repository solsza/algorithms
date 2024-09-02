package org.example.solutions.dynamic;

import org.example.solutions.DefaultSolution;

import java.util.HashMap;
import java.util.List;

public class ArrayStepper implements DefaultSolution {

    private boolean arrayStepper(List<Integer> nums) {
        return arrayStepper(0, nums, new HashMap<>());
    }

    private boolean arrayStepper(int idx, List<Integer> nums, HashMap<Integer, Boolean> memo) {
        if (idx >= nums.size() - 1) return true;
        if (memo.containsKey(idx)) return memo.get(idx);
        for (int step = 1; step <= nums.get(idx); step += 1) {
            if (arrayStepper(idx + step, nums, memo)) {
                memo.put(idx, true);
                return true;
            }
        }
        memo.put(idx, false);
        return false;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(arrayStepper(List.of(2, 4, 2, 0, 0, 1))); // -> true
        System.out.println(arrayStepper(List.of(
                31, 30, 29, 28, 27,
                26, 25, 24, 23, 22,
                21, 20, 19, 18, 17,
                16, 15, 14, 13, 12,
                11, 10, 9, 8, 7, 6,
                5, 3, 2, 1, 0, 0, 0
        ))); // -> false
    }
}
