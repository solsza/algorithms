package org.example.solutions.graph;

import org.example.solutions.DefaultSolution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class KnightAttack implements DefaultSolution {

    private int knightAttack(int n, int kr, int kc, int pr, int pc) {
        HashSet<List<Integer>> visited = new HashSet<>();
        ArrayDeque<List<Integer>> queue = new ArrayDeque<>();
        queue.add(List.of(kr, kc, 0));
        visited.add(List.of(kr, kc));
        while (!queue.isEmpty()) {
            List<Integer> entry = queue.remove();
            int r = entry.get(0);
            int c = entry.get(1);
            int distance = entry.get(2);
            if (r == pr && c == pc) {
                return distance;
            }
            List<List<Integer>> neighbors = getKnightMoves(n, r, c);
            for (List<Integer> neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    int neighborRow = neighbor.get(0);
                    int neighborCol = neighbor.get(1);
                    queue.add(List.of(neighborRow, neighborCol, distance + 1));
                    visited.add(neighbor);
                }
            }
        }
        return -1;
    }

    private List<List<Integer>> getKnightMoves(int n, int r, int c) {
        List<List<Integer>> positions = List.of(
                List.of(r + 2, c + 1),
                List.of(r - 2, c + 1),
                List.of(r + 2, c - 1),
                List.of(r - 2, c - 1),
                List.of(r + 1, c + 2),
                List.of(r - 1, c + 2),
                List.of(r + 1, c - 2),
                List.of(r - 1, c - 2)
        );

        List<List<Integer>> inboundPositions = new ArrayList<>();
        for (List<Integer> position : positions) {
            int newRow = position.get(0);
            int newCol = position.get(1);

            if (0 <= newRow && newRow < n && 0 <= newCol && newCol < n) {
                inboundPositions.add(List.of(newRow, newCol));
            }
        }

        return inboundPositions;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(knightAttack(8, 1, 1, 2, 2)); // -> 2
        System.out.println(knightAttack(3, 0, 0, 1, 1)); // -> -1
    }
}
