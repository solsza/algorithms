package org.example.solutions;

import java.util.HashMap;
import java.util.List;

public class BreakingBoundaries implements DefaultSolution {

    private int breakingBoundaries(int m, int n, int k, int r, int c) {
        return breakingBoundaries(m, n, k, r, c, new HashMap<>());
    }

    private int breakingBoundaries(int m, int n, int k, int r, int c, HashMap<List<Integer>, Integer> memo) {
        List<Integer> key = List.of(k, r, c);
        if (memo.containsKey(key)) return memo.get(key);
        if (k == -1) return 0;
        if (r < 0 || r >= m || c < 0 || c >= n) return 1;
        int answer = breakingBoundaries(m, n, k - 1, r + 1, c, memo)
            + breakingBoundaries(m, n, k - 1, r - 1, c, memo)
            + breakingBoundaries(m, n, k - 1, r, c + 1, memo)
            + breakingBoundaries(m, n, k - 1, r, c - 1, memo);
        memo.put(key, answer);
        return answer;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(breakingBoundaries(3, 4, 2, 0, 0)); // -> 4
        System.out.println(breakingBoundaries(6, 6, 12, 3, 4)); // -> 871065
    }
}
