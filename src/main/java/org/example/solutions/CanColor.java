package org.example.solutions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CanColor implements DefaultSolution {

    private boolean canColor(Map<String, List<String>> graph) {
        HashMap<String, Boolean> coloring = new HashMap<>();
        for(String node : graph.keySet()) {
            if (!coloring.containsKey(node) && !isValid(graph, node, coloring, false)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(Map<String, List<String>> graph, String node, HashMap<String, Boolean> memo, boolean currentColor) {
        if(memo.containsKey(node)) {
            return currentColor == canColor(graph);
        }
        memo.put(node, currentColor);
        for (String neighbor : graph.get(node)) {
            if(!isValid(graph, neighbor, memo, !currentColor)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(canColor(Map.of(
                "x", List.of("y"),
                "y", List.of("x","z"),
                "z", List.of("y")
        ))); // -> true
        System.out.println(canColor(Map.of(
                "a", List.of("b", "c", "d"),
                "b", List.of("a"),
                "c", List.of("a"),
                "d", List.of("a")
        ))); // -> true
    }
}
