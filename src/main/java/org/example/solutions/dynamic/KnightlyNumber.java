package org.example.solutions.dynamic;

import org.example.solutions.DefaultSolution;

import java.util.HashMap;
import java.util.List;

public class KnightlyNumber implements DefaultSolution {

    private int knightlyNumber(int n, int m, int kr, int kc, int pr, int pc) {
        return knightlyNumber(n, m, kr, kc, pr, pc, new HashMap<>());
    }

    private int knightlyNumber(int n, int m, int kr, int kc, int pr, int pc, HashMap<List<Integer>, Integer> memo) {
        if (kr < 0 || kr >= n || kc < 0 || kc >= n) {
            return 0;
        }

        if (m == 0) {
            if (kr == pr && kc == pc) {
                return 1;
            } else {
                return 0;
            }
        }

        List<Integer> key = List.of(m, kr, kc);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        List<List<Integer>> deltas = List.of(
                List.of(1, 2),
                List.of(1, -2),
                List.of(-1, 2),
                List.of(-1, -2),
                List.of(2, 1),
                List.of(2, -1),
                List.of(-2, 1),
                List.of(-2, -1)
        );

        int total = 0;
        for (List<Integer> delta : deltas) {
            int dRow = delta.get(0);
            int dCol = delta.get(1);
            int newRow = kr + dRow;
            int newCol = kc + dCol;
            total += knightlyNumber(n, m - 1, newRow, newCol, pr, pc, memo);
        }

        memo.put(key, total);
        return total;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(knightlyNumber(8, 2, 4, 4, 5, 5)); // -> 2
        System.out.println(knightlyNumber(20, 12, 8, 3, 9, 14)); // -> 98410127
    }
}
