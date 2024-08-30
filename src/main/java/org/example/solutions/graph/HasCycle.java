package org.example.solutions.graph;

import org.example.solutions.DefaultSolution;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class HasCycle implements DefaultSolution {

    private boolean hasCycle(Map<String, List<String>> graph) {
        HashSet<String> visited = new HashSet<>();
        for (String node : graph.keySet()) {
            if (cycleDetect(node, graph, new HashSet<>(), visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean cycleDetect(String node, Map<String, List<String>> graph, HashSet<String> visiting, HashSet<String> visited) {
        if (visited.contains(node)) {
            return false;
        }
        if (visiting.contains(node)) {
            return true;
        }
        visiting.add(node);
        for (String neighbor : graph.get(node)) {
            if (cycleDetect(neighbor, graph, visiting, visited)) {
                return true;
            }
        }
        visiting.remove(node);
        visited.add(node);
        return false;
    }


    @Override
    public void runDefaultExample() {
        System.out.println(hasCycle(Map.of(
                "a", List.of("b"),
                "b", List.of("c"),
                "c", List.of("a"),
                "g", List.of()
        ))); // -> true
    }
}
