package org.example.solutions;

import java.util.HashMap;
import java.util.List;

public class MaxIncreasingSubsets implements DefaultSolution {

    private int maxIncreasingSubseq(List<Integer> numbers) {

        HashMap<List<Integer>, Integer> memo = new HashMap<>();
        return maxIncreasingSubseq(numbers, 0, -1, memo);
    }

    private int maxIncreasingSubseq(List<Integer> numbers, int i, int prevNum, HashMap<List<Integer>, Integer> memo) {
        if (i == numbers.size()) {
            return 0;
        }
        int currentNum = numbers.get(i);

        List<Integer> key = List.of(i, prevNum);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int dontTake = maxIncreasingSubseq(numbers, i + 1, prevNum, memo);
        int take = -1;
        if (currentNum > dontTake) {
            take = 1 + maxIncreasingSubseq(numbers, i + 1, currentNum, memo);
        }
        int max = Math.max(dontTake, take);
        memo.put(key, max);
        return max;
    }


    @Override
    public void runDefaultExample() {

    }
}
