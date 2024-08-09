package org.example.solutions.graph;

import org.example.solutions.DefaultSolution;

import java.util.*;

/**
 * assumption: graph does not have cyclic path
 */
public class BreadthFirstHasPathForCyclingNodes implements DefaultSolution {

    boolean pathExistsSourceMethode(Map<String, List<String>> graph, String source, String endNode) {
        Set<String> visitedNodes = new HashSet<>();
        return pathExists(graph, source, endNode, visitedNodes);
    }

    boolean pathExists(Map<String, List<String>> graph, String source, String endNode, Set<String> visitedNodes) {
        if (Objects.equals(source, endNode)) return true;
        if (visitedNodes.contains(source)) return false;
        visitedNodes.add(source);

        for (String node : graph.get(source)) {
            if (pathExists(graph, node, endNode, visitedNodes)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void runDefaultExample() {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", List.of("C", "B"));
        graph.put("B", List.of("D","C"));
        graph.put("C", List.of("E","B"));
        graph.put("D", List.of());
        graph.put("E", List.of("B"));
        graph.put("F", List.of("D"));
        System.out.println("Breadth First has path Example");
        System.out.println(pathExistsSourceMethode(graph, "A", "D"));
    }
}
