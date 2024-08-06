package org.example.solutions.graph;

import org.example.solutions.DefaultSolution;

import java.util.*;

public class BreadthFirstTraversal implements DefaultSolution {

    public String breadthFirstTraversal(Map<String, List<String>> graph, String source) {
        Queue<String> queue = new LinkedList<>();
        List<String> visited = new ArrayList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            visited.add(current);
            for (String neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }
        return Arrays.toString(visited.toArray());
    }


    @Override
    public void runDefaultExample() {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", List.of("C", "B"));
        graph.put("B", List.of("D"));
        graph.put("C", List.of("E"));
        graph.put("D", List.of());
        graph.put("E", List.of("B"));
        graph.put("F", List.of("D"));
        System.out.println("Depth First Traversal Example");
        System.out.println(breadthFirstTraversal(graph, "A"));
    }
}
