package org.example.solutions.graph;

import org.example.solutions.DefaultSolution;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

public class BestBridge implements DefaultSolution {

    private int bestBridge(List<List<String>> grid) {
        HashSet<List<Integer>> mainIsland = null;
        for (int r = 0; r < grid.size(); r += 1) {
            for (int c = 0; c < grid.get(0).size(); c += 1) {
                HashSet<List<Integer>> island = traverseIsland(r, c, grid, new HashSet<>());
                if (island.size() > 0) {
                    mainIsland = island;
                }
            }
        }

        HashSet<List<Integer>> visited = new HashSet<>();
        ArrayDeque<List<Integer>> queue = new ArrayDeque<>();
        for (List<Integer> pos : mainIsland) {
            int r = pos.get(0);
            int c = pos.get(1);
            queue.add(List.of(r, c, 0));
            visited.add(pos);
        }

        while (!queue.isEmpty()) {
            List<Integer> entry = queue.remove();
            int r = entry.get(0);
            int c = entry.get(1);
            int distance = entry.get(2);
            List<Integer> pos = List.of(r, c);

            if (grid.get(r).get(c) == "L" && !mainIsland.contains(pos)) {
                return distance - 1;
            }

            List<List<Integer>> deltas = List.of(
                    List.of(1, 0),
                    List.of(-1, 0),
                    List.of(0, 1),
                    List.of(0, -1)
            );

            for (List<Integer> delta : deltas) {
                int newRow = r + delta.get(0);
                int newCol = c + delta.get(1);
                List<Integer> newPos = List.of(newRow, newCol);
                if (isInbounds(newRow, newCol, grid) && !visited.contains(newPos)) {
                    visited.add(newPos);
                    queue.add(List.of(newRow, newCol, distance + 1));
                }
            }
        }

        return -1;
    }

    private boolean isInbounds(int r, int c, List<List<String>> grid) {
        boolean rowInbounds = 0 <= r && r < grid.size();
        boolean colInbounds = 0 <= c && c < grid.get(0).size();
        return rowInbounds && colInbounds;
    }

    private HashSet<List<Integer>> traverseIsland(int r, int c, List<List<String>> grid, HashSet<List<Integer>> visited) {
        if (!isInbounds(r, c, grid)) {
            return visited;
        }

        if (grid.get(r).get(c) == "W") {
            return visited;
        }

        List<Integer> pos = List.of(r, c);
        if (visited.contains(pos)) {
            return visited;
        }
        visited.add(pos);

        traverseIsland(r + 1, c, grid, visited);
        traverseIsland(r - 1, c, grid, visited);
        traverseIsland(r, c + 1, grid, visited);
        traverseIsland(r, c - 1, grid, visited);
        return visited;
    }

    @Override
    public void runDefaultExample() {
        List<List<String>> grid = List.of(
                List.of("W", "W", "W", "L", "L"),
                List.of("L", "L", "W", "W", "L"),
                List.of("L", "L", "L", "W", "L"),
                List.of("W", "L", "W", "W", "W"),
                List.of("W", "W", "W", "W", "W"),
                List.of("W", "W", "W", "W", "W")
        );
        bestBridge(grid); // -> 1
    }
}
