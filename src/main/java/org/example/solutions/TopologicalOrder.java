package org.example.solutions;

import java.util.*;

public class TopologicalOrder implements DefaultSolution {
    private List<String> topologicalOrder(Map<String, List<String>> graph) {
        Map<String, Integer> numParents = new HashMap<>();
        for (String node : graph.keySet()) {
            numParents.put(node, 0);
        }
        for (String node : graph.keySet()) {
            for (String child : graph.get(node)) {
                numParents.put(child, numParents.get(child) + 1);
            }
        }

        Stack<String> ready = new Stack<>();
        for (String node : graph.keySet()) {
            if (numParents.get(node) == 0) {
                ready.push(node);
            }
        }

        List<String> order = new ArrayList<>();
        while (!ready.isEmpty()) {
            String node = ready.pop();
            order.add(node);
            for (String child : graph.get(node)) {
                numParents.put(child, numParents.get(child) - 1);
                if (numParents.get(child) == 0) {
                    ready.push(child);
                }
            }
        }
        return order;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(topologicalOrder(Map.of(
                "a", List.of("f"),
                "b", List.of("d"),
                "c", List.of("a", "f"),
                "d", List.of("e"),
                "e", List.of(),
                "f", List.of("b", "e")
        ))); // -> ["c", "a", "f", "b", "d", "e"]
        System.out.println(topologicalOrder(Map.of(
                "q", List.of(),
                "r", List.of("q"),
                "s", List.of("r"),
                "t", List.of("s")
        ))); // -> ["t", "s", "r", "q"]
    }
}
