package org.example.solutions;

import java.util.ArrayList;
import java.util.List;

public class StringSearch implements DefaultSolution {
    private boolean stringSearch(List<List<String>> grid, String s) {
        for (int r = 0; r < grid.size(); r += 1) {
            for (int c = 0; c < grid.get(0).size(); c += 1) {
                if (dfs(grid, s, r, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(List<List<String>> grid, String s, int r, int c) {
        if (s.isEmpty()) return true;
        boolean rowInbounds = r >= 0 && r < grid.size();
        boolean colInbounds = c >= 0 && c < grid.get(0).size();
        if (!rowInbounds || !colInbounds) return false;
        String current = grid.get(r).get(c);
        if (!current.equals(Character.toString(s.charAt(0)))) {
            return false;
        }
        String suffix = s.substring(1);
        grid.get(r).set(c, "*");
        boolean result = dfs(grid, suffix, r - 1, c)
                || dfs(grid, suffix, r + 1, c)
                || dfs(grid, suffix, r, c - 1)
                || dfs(grid, suffix, r, c + 1);
        grid.get(r).set(c, current);
        return result;
    }


    @Override
    public void runDefaultExample() {
        List<List<String>> grid = List.of(
                new ArrayList<>(List.of("e", "y", "h", "i", "j")),
                new ArrayList<>(List.of("q", "x", "e", "r", "p")),
                new ArrayList<>(List.of("r", "o", "l", "l", "n")),
                new ArrayList<>(List.of("p", "r", "x", "o", "h")),
                new ArrayList<>(List.of("a", "a", "m", "c", "m"))
        );
        System.out.println(stringSearch(grid, "hello")); // -> true
        List<List<String>> grid1 = List.of(
                new ArrayList<>(List.of("e", "y", "h", "i", "j")),
                new ArrayList<>(List.of("q", "x", "e", "r", "p")),
                new ArrayList<>(List.of("r", "o", "l", "l", "n")),
                new ArrayList<>(List.of("p", "r", "x", "o", "h")),
                new ArrayList<>(List.of("a", "a", "m", "z", "m"))
        );
        System.out.println(stringSearch(grid1, "zoo")); // -> false
    }
}
