package org.example.solutions.dynamic;

import org.example.solutions.DefaultSolution;

import java.util.HashMap;
import java.util.List;

public class CountPaths implements DefaultSolution {

    private int countPaths(List<List<String>> grid) {
        return countPaths(grid, 0, 0, new HashMap<>());
    }

    private int countPaths(List<List<String>> grid, int r, int c, HashMap<List<Integer>, Integer> memo) {
        if (r == grid.size() || c == grid.get(0).size()) return 0;
        if (grid.get(r).get(c).equals("X")) return 0;
        if (r == grid.size() - 1 && c == grid.get(0).size() - 1) return 1;
        List<Integer> pos = List.of(r, c);
        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }
        int result = countPaths(grid, r + 1, c, memo) + countPaths(grid, r, c + 1, memo);
        memo.put(pos, result);
        return result;
    }

    @Override
    public void runDefaultExample() {
        List<List<String>> grid = List.of(
                List.of("O", "O", "X", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "X"),
                List.of("X", "O", "O", "O", "O", "O"),
                List.of("X", "X", "X", "O", "O", "O"),
                List.of("O", "O", "O", "O", "O", "O")
        );
        System.out.println(countPaths(grid)); // -> 42

    }
}
