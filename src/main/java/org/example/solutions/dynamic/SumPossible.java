package org.example.solutions.dynamic;

import org.example.solutions.DefaultSolution;

import java.util.HashMap;
import java.util.List;

public class SumPossible implements DefaultSolution {

    private boolean sumPossible(int amount, List<Integer> numbers) {
        return sumPossibleRecursive(amount, numbers, new HashMap<>());
    }

    private boolean sumPossibleRecursive(int amount, List<Integer> numbers, HashMap<Integer, Boolean> memo) {
        //we touch the leaf of the tree
        if (amount == 0) {
            return true;
        }
        //we can have that we subtract amount - number e.g. amount = 2, value in numbers > 2
        if (amount < 0) {
            return false;
        }

        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        for (int number : numbers) {
            if (sumPossibleRecursive(amount - number, numbers, memo)) {
                memo.put(amount, true);
                return true;
            }
        }
        memo.put(amount, false);
        return false;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(sumPossible(103, List.of(6, 20, 1)));
        System.out.println(sumPossible(271, List.of(10, 8, 265, 24)));
    }
}
