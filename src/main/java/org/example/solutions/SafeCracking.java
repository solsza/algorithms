package org.example.solutions;

import java.util.*;

public class SafeCracking implements DefaultSolution {

    public static String safeCracking(List<List<Integer>> hints) {
        Map<Integer, List<Integer>> graph = createGraph(hints);
        Map<Integer, Integer> nodeWithNumberOfParents = new HashMap<>();
        for (Integer node : graph.keySet()) {
            nodeWithNumberOfParents.put(node, 0);
        }
        for (Integer node : graph.keySet()) {
            for (Integer children : graph.get(node)) {
                nodeWithNumberOfParents.put(children, nodeWithNumberOfParents.get(children) + 1);
            }
        }

        Stack<Integer> ready = new Stack<>();
        for (Integer node : nodeWithNumberOfParents.keySet()) {
            if (nodeWithNumberOfParents.get(node) == 0) {
                ready.add(node);
            }
        }

        List<String> result = new ArrayList<>();
        while (!ready.isEmpty()) {
            Integer current = ready.pop();
            result.add(Integer.toString(current));
            for (Integer child : graph.get(current)) {
                nodeWithNumberOfParents.put(child, nodeWithNumberOfParents.get(child) - 1);
                if (nodeWithNumberOfParents.get(child) == 0) {
                    ready.add(child);
                }
            }
        }
        return String.join("", result);
    }

    private static Map<Integer, List<Integer>> createGraph(List<List<Integer>> hints) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> edge : hints) {
            int nodeA = edge.get(0);
            int nodeB = edge.get(1);
            if (!graph.containsKey(nodeA)) {
                graph.put(nodeA, new ArrayList<>());
            }
            if (!graph.containsKey(nodeB)) {
                graph.put(nodeB, new ArrayList<>());
            }
            graph.get(nodeA).add(nodeB);
        }
        return graph;
    }

    @Override
    public void runDefaultExample() {
        safeCracking(List.of(
                List.of(7, 1),
                List.of(1, 8),
                List.of(7, 8)
        ));
    }
}
