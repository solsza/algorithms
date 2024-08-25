package org.example.solutions.graph;

import org.example.solutions.DefaultSolution;

import java.util.AbstractMap.SimpleEntry;
import java.util.*;

public class ShortestPath implements DefaultSolution {

    private int shortestPath(List<List<String>> edges, String nodeA, String nodeB) {
        HashMap<String, List<String>> graph = buildGraph(edges);
        HashSet<String> visited = new HashSet<>();
        Queue<SimpleEntry<String, Integer>> queue = new LinkedList<>();
        queue.add(new SimpleEntry<>(nodeA, 0));
        visited.add(nodeA);
        while (!queue.isEmpty()) {
            SimpleEntry<String, Integer> current = queue.poll();
            String node = current.getKey();
            int distance = current.getValue();

            if (Objects.equals(node, nodeB)) {
                return distance;
            }

            for (String neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    queue.add(new SimpleEntry<>(neighbor, distance + 1));
                    visited.add(neighbor);
                }
            }
        }
        return -1;
    }


    private HashMap<String, List<String>> buildGraph(List<List<String>> edges) {
        HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
        for (List<String> edge : edges) {
            String a = edge.get(0);
            String b = edge.get(1);
            if (!graph.containsKey(a)) {
                graph.put(a, new ArrayList<>());
            }
            if (!graph.containsKey(b)) {
                graph.put(b, new ArrayList<>());
            }
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return graph;
    }


    @Override
    public void runDefaultExample() {
        List<List<String>> edges = List.of(
                List.of("w", "x"),
                List.of("x", "y"),
                List.of("z", "y"),
                List.of("z", "v"),
                List.of("w", "v")
        );
        List<List<String>> edges2 = List.of(
                List.of("w", "x"),
                List.of("x", "y"),
                List.of("z", "y"),
                List.of("z", "v"),
                List.of("w", "v")
        );
        System.out.println("First : " + shortestPath(edges, "w", "z"));
        System.out.println("Second : " + shortestPath(edges2, "y", "x"));

    }
}
