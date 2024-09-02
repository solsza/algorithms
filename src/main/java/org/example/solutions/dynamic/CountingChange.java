package org.example.solutions.dynamic;

import org.example.solutions.DefaultSolution;

import java.util.HashMap;
import java.util.List;

public class CountingChange implements DefaultSolution {

    private int countingChange(int amount, List<Integer> coins) {
        return countingChange(amount, 0, coins, new HashMap<>());
    }

    private int countingChange(int amount, int coinIdx, List<Integer> coins, HashMap<List<Integer>, Integer> memo) {
        if (amount == 0) return 1;
        if (coinIdx == coins.size()) return 0;
        List<Integer> key = List.of(amount, coinIdx);
        if (memo.containsKey(key)) return memo.get(key);
        int total = 0;
        for (int qty = 0; qty * coins.get(coinIdx) <= amount; qty += 1) {
            int subAmount = amount - (qty * coins.get(coinIdx));
            total += countingChange(subAmount, coinIdx + 1, coins, memo);
        }

        memo.put(key, total);
        return total;
    }


    @Override
    public void runDefaultExample() {
        System.out.println(countingChange(4, List.of(1, 2, 3))); // -> 4
        System.out.println(countingChange(240, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9))); // -> 1525987916
    }
}
