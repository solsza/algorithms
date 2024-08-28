package org.example.solutions.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.example.solutions.DefaultSolution;

public class CalculateConnectedComponents implements DefaultSolution {

    private int countOfConnectedComponents(Map<String, List<String>> graph) {
        Set<String> visited = new HashSet<String>();
        int counter = 0;
        for (String node : graph.keySet()) {
            if (explore(graph, node, visited)) {
                counter++;
            }
        }
        return counter;
    }

    private boolean explore(Map<String, List<String>> graph, String sourceNode, Set<String> visitedNode) {
        if (visitedNode.contains(sourceNode)) {
            return false;
        }
        visitedNode.add(sourceNode);
        for (String neighbor : graph.get(sourceNode)) {
            explore(graph, neighbor, visitedNode);
        }
        return true;
    }


    @Override
    public void runDefaultExample() {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("0", List.of("8", "1", "5"));
        graph.put("1", List.of("0"));
        graph.put("5", List.of("0", "8"));
        graph.put("8", List.of("0", "5"));
        graph.put("2", List.of("4", "4"));
        graph.put("3", List.of("2", "4"));
        graph.put("4", List.of("3", "2"));
        System.out.println(countOfConnectedComponents(graph));

    }
}
