package org.example.solutions.graph;

import org.example.solutions.DefaultSolution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * assumption: graph does not have cyclic path
 */
public class DepthFirstHasPath implements DefaultSolution {

    boolean pathExists(Map<String, List<String>> graph, String source, String endNode) {
        if (Objects.equals(source, endNode)) return true;
        for (String node : graph.get(source)) {
            if (pathExists(graph, node, endNode)) {
                return true;
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
        System.out.println("Breadth First has path Example");
        System.out.println(pathExists(graph, "A", "D"));
    }
}
