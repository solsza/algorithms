package org.example.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RareRouting implements DefaultSolution {

    private boolean rareRouting(int n, List<List<Integer>> roads) {
        HashMap<Integer, List<Integer>> graph = buildGraph(n, roads);
        HashSet<Integer> visited = new HashSet<>();
        boolean valid = validate(graph, 0, visited, -1);
        return valid && visited.size() == n;
    }

    private boolean validate(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited, Integer prevNode) {
        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);
        for (int neighbor : graph.get(node)) {
            if (neighbor != prevNode && !validate(graph, neighbor, visited, node)) {
                return false;
            }
        }
        return true;
    }

    private HashMap<Integer, List<Integer>> buildGraph(int n, List<List<Integer>> roads) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (List<Integer> road : roads) {
            graph.get(road.get(0)).add(road.get(1));
            graph.get(road.get(1)).add(road.get(0));
        }
        return graph;
    }


    @Override
    public void runDefaultExample() {
        System.out.println(rareRouting(4, List.of(
            List.of(0, 1),
            List.of(0, 2),
            List.of(0, 3)
        ))); // -> true
        System.out.println(rareRouting(6, List.of(
            List.of(1, 2),
            List.of(4, 1),
            List.of(5, 4),
            List.of(3, 0),
            List.of(0, 1),
            List.of(0, 4)
        ))); // -> true
    }
}
