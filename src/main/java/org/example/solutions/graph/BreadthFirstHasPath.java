package org.example.solutions.graph;

import org.example.solutions.DefaultSolution;

import java.util.*;

public class BreadthFirstHasPath implements DefaultSolution {


    boolean pathExists(Map<String, List<String>> graph, String startNode, String endNode) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            startNode = queue.poll();
            if(startNode.equals(endNode)) {
                return true;
            }
            for (String neighbor : graph.get(startNode)) {
                queue.add(neighbor);
            }
        }
        return false;
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
        System.out.println("Depth First has path Example");
        System.out.println(pathExists(graph, "A", "D"));
    }
}
