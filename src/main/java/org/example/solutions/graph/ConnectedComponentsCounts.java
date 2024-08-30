package org.example.solutions.graph;

import org.example.solutions.DefaultSolution;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConnectedComponentsCounts implements DefaultSolution {

    private int connectedComponentsCount(Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        int connectedComponentsCount = 0;
        for (Integer node : graph.keySet()) {
            if (dfs(graph, node, visited)) {
                connectedComponentsCount++;
            }
        }
        return connectedComponentsCount;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, Integer node, Set<Integer> visited) {
        if (visited.contains(node)) return false;
        visited.add(node);
        List<Integer> neighbors = graph.get(node);
        for (Integer neighbor : neighbors) {
            dfs(graph, neighbor, visited);
        }
        return true;
    }


    @Override
    public void runDefaultExample() {
        System.out.println(connectedComponentsCount(Map.of(
                0, List.of(8, 1, 5),
                1, List.of(0),
                5, List.of(0, 8),
                8, List.of(0, 5),
                2, List.of(3, 4),
                3, List.of(2, 4),
                4, List.of(3, 2)
        ))); // -> 2
    }
}
