package org.example.solutions.graph;

import org.example.solutions.DefaultSolution;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class IslandCountProblem implements DefaultSolution {

    private int islandCount(List<List<String>> grid) {
        HashSet<SimpleEntry<Integer, Integer>> visited = new HashSet<>();
        int count = 0;
        for (int r = 0; r < grid.size(); r += 1) {
            for (int c = 0; c < grid.get(0).size(); c += 1) {
                if(explore(r, c, grid, visited)) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public static boolean explore(int r, int c, List<List<String>> grid, HashSet<SimpleEntry<Integer, Integer>> visited) {
        boolean rowInbounds = r >= 0 && r < grid.size();
        boolean colInbounds = c >= 0 && c < grid.get(0).size();
        if (!rowInbounds || !colInbounds) {
            return false;
        }

        if (grid.get(r).get(c).equals("W")) {
            return false;
        }

        SimpleEntry<Integer, Integer> key = new SimpleEntry<>(r, c);
        if (visited.contains(key)) {
            return false;
        }
        visited.add(key);

        explore(r + 1, c, grid, visited);
        explore(r - 1, c, grid, visited);
        explore(r, c + 1, grid, visited);
        explore(r, c - 1, grid, visited);

        return true;
    }

    @Override
    public void runDefaultExample() {
        List<List<String>> grid = List.of(
                List.of("W", "L", "W", "W", "W"),
                List.of("W", "L", "W", "W", "W"),
                List.of("W", "W", "W", "L", "W"),
                List.of("W", "W", "L", "L", "W"),
                List.of("L", "W", "W", "L", "L"),
                List.of("L", "L", "W", "W", "W")
        );

        List<List<String>> grid1 = List.of(
                List.of("L", "W", "W", "L", "W"),
                List.of("L", "W", "W", "L", "L"),
                List.of("W", "L", "W", "L", "W"),
                List.of("W", "W", "W", "W", "W"),
                List.of("W", "W", "L", "L", "L")
        );

        System.out.println(islandCount(grid));
        System.out.println(islandCount(grid1));
    }
}
