package org.example.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TolerantTeams implements DefaultSolution{

    private boolean tolerantTeams(List<List<String>> rivalries) {
        Map<String, List<String>> graph = createGraph(rivalries);
        Map<String, Boolean> visited = new HashMap<String, Boolean>();
        for (String node : graph.keySet()) {
            if (!visited.containsKey(node) && !traverse(graph, node, visited, false)) return false;
        }
        return true;
    }


    private boolean traverse(Map<String, List<String>> graph, String node, Map<String, Boolean> visited, boolean currentValue) {
        if (visited.containsKey(node)) {
            return visited.get(node) == currentValue;
        }
        visited.put(node, currentValue);
        for (String neighbor : graph.get(node)) {
            if (!traverse(graph, neighbor, visited, !currentValue)) {
                return false;
            }
        }
        return true;
    }

    private Map<String, List<String>> createGraph(List<List<String>> rivalries) {
        Map<String, List<String>> result = new HashMap<>();
        for (List<String> rivales : rivalries) {
            String rival1 = rivales.get(0);
            String rival2 = rivales.get(1);
            result.computeIfAbsent(rival1, v -> new ArrayList<>()).add(rival2);
            result.computeIfAbsent(rival2, v -> new ArrayList<>()).add(rival1);
        }
        return result;
    }


    @Override
    public void runDefaultExample() {
        System.out.println(tolerantTeams(List.of(
            List.of("philip", "seb"),
            List.of("raj", "nader")
        )));

        System.out.println(tolerantTeams(List.of(
            List.of("philip", "seb"),
            List.of("raj", "nader"),
            List.of("raj", "philip"),
            List.of("seb", "raj")
        ))); // -> false
    }
}
