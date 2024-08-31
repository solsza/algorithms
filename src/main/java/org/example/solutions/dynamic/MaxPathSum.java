package org.example.solutions.dynamic;

import org.example.solutions.DefaultSolution;

import java.util.HashMap;
import java.util.List;

public class MaxPathSum implements DefaultSolution {

    private int maxPathSum(List<List<Integer>> grid) {
        return (int) maxPathSum(0, 0, grid, new HashMap<>());
    }

    private double maxPathSum(int r, int c, List<List<Integer>> grid, HashMap<List<Integer>, Double> memo) {
        if (r == grid.size() || c == grid.get(0).size()) {
            return Double.NEGATIVE_INFINITY;
        }

        if (r == grid.size() - 1 && c == grid.get(0).size() - 1) {
            return grid.get(r).get(c);
        }

        List<Integer> pos = List.of(r, c);
        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }

        double result = grid.get(r).get(c) + Math.max(
                maxPathSum(r + 1, c, grid, memo),
                maxPathSum(r, c + 1, grid, memo)
        );
        memo.put(pos, result);
        return result;
    }


    @Override
    public void runDefaultExample() {
        List<List<Integer>> grid = List.of(
                List.of(1, 3, 12),
                List.of(5, 1, 1),
                List.of(3, 6, 1)
        );
        System.out.println(maxPathSum(grid)); // -> 18
    }
}
