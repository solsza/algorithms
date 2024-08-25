package org.example.solutions.graph;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.List;
import org.example.solutions.DefaultSolution;

public class MinimumIsland implements DefaultSolution {

    private int minimumIsland(List<List<String>> grid) {
        HashSet<SimpleEntry<Integer, Integer>> visited = new HashSet<>();
        double min = Double.POSITIVE_INFINITY;
        for (int r = 0; r < grid.size(); r += 1) {
            for (int c = 0; c < grid.get(0).size(); c += 1) {
                double size = exploreSize(r, c, grid, visited);
                if (size > 0 && size < min) {
                    min = size;
                }
            }
        }
        return (int) min;
    }

    private int exploreSize(int r, int c, List<List<String>> grid, HashSet<SimpleEntry<Integer, Integer>> visited) {
        boolean rowInbounds = 0 <= r && r < grid.size();
        boolean colInbounds = 0 <= c && c < grid.get(0).size();
        if (!rowInbounds || !colInbounds) {
            return 0;
        }

        if (grid.get(r).get(c).equals("W")) {
            return 0;
        }

        SimpleEntry<Integer, Integer> key = new SimpleEntry<>(r, c);
        if (visited.contains(key)) {
            return 0;
        }
        visited.add(key);

        int totalSize = 1;
        totalSize += exploreSize(r + 1, c, grid, visited);
        totalSize += exploreSize(r - 1, c, grid, visited);
        totalSize += exploreSize(r, c + 1, grid, visited);
        totalSize += exploreSize(r, c - 1, grid, visited);
        return totalSize;
    }


    @Override
    public void runDefaultExample() {
        List<List<String>> first = List.of(
            List.of("W", "L", "W", "W", "W"),
            List.of("W", "L", "W", "W", "W"),
            List.of("W", "W", "W", "L", "W"),
            List.of("W", "W", "L", "L", "W"),
            List.of("L", "W", "W", "L", "L"),
            List.of("L", "L", "W", "W", "W")
        );

        List<List<String>> second = List.of(
            List.of("L", "L", "L"),
            List.of("L", "L", "L"),
            List.of("L", "L", "L")
        );

        System.out.println(minimumIsland(first));
        System.out.println(minimumIsland(second));
    }
}
