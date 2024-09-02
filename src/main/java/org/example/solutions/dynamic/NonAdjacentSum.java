package org.example.solutions.dynamic;

import org.example.solutions.DefaultSolution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonAdjacentSum implements DefaultSolution {

    private int nonAdjacentSum(List<Integer> nums) {
        return nonAdjacentSum(nums, 0, new HashMap<>());
    }

    public int nonAdjacentSum(List<Integer> nums, int index, Map<Integer, Integer> memo) {
        if (index >= nums.size()) return 0;
        if (memo.containsKey(index)) return memo.get(index);
        int result = Math.max(nums.get(index) + nonAdjacentSum(nums, index + 2, memo), nonAdjacentSum(nums, index + 1, memo));
        memo.put(index, result);
        return result;
    }

    @Override
    public void runDefaultExample() {
        List<Integer> nums = List.of(2, 4, 5, 12, 7);
        System.out.println(nonAdjacentSum(nums)); // -> 16
    }
}
