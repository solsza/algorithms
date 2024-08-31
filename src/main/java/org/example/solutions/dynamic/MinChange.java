package org.example.solutions.dynamic;

import org.example.solutions.DefaultSolution;

import java.util.HashMap;
import java.util.List;

public class MinChange implements DefaultSolution {

    private int minChange(int amount, List<Integer> coins) {
        return minChange(amount, coins, new HashMap<>());
    }

    private int minChange(int amount, List<Integer> coins, HashMap<Integer, Integer> memo) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo.containsKey(amount)) return memo.get(amount);
        int minCoins = -1;
        for (int coin : coins) {
            int subAmount = amount - coin;
            int subCoins = minChange(subAmount, coins, memo);
            if (subCoins != -1) {
                int numCoins = 1 + subCoins;
                if (numCoins < minCoins || minCoins == -1) {
                    minCoins = numCoins;
                }
            }
        }
        memo.put(amount, minCoins);
        return minCoins;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(minChange(13, List.of(1, 9, 5, 14, 30))); // -> 5
        System.out.println(minChange(271, List.of(10, 8, 265, 24))); // -> -1
    }
}
