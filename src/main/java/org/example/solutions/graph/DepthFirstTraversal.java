package org.example.solutions.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.example.solutions.DefaultSolution;

public class DepthFirstTraversal implements DefaultSolution {

    public String depthFirstTraversal(Map<String, List<String>> graph, String source) {
        Stack<String> stack = new Stack<>();
        List<String> path = new ArrayList<>();
        stack.push(source);
        while (!stack.isEmpty()) {
            String current = stack.pop();
            if (!path.contains(current)) {
                path.add(current);
            }
            List<String> neighbors = graph.get(current);
            for (String neighbor : neighbors) {
                stack.push(neighbor);
            }
        }
        return Arrays.toString(path.toArray());
    }

    public String depthFirstTraversalRecursive(Map<String, List<String>> graph, String source) {
        Stack<String> stack = new Stack<>();
        List<String> values = new ArrayList<>();
        stack.push(source);
        values.add(source);
        return recursiveOne(graph, values, stack);
    }

    private String recursiveOne(Map<String, List<String>> graph, List<String> currentValues, Stack<String> stack) {
        if (stack.isEmpty()) {
            return Arrays.toString(currentValues.toArray());
        }
        String current = stack.pop();
        if (!currentValues.contains(current)) {
            currentValues.add(current);
        }
        for (String neighbor : graph.get(current)) {
            stack.push(neighbor);
        }
        return recursiveOne(graph, currentValues, stack);
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
        System.out.println(depthFirstTraversal(graph, "A"));
        System.out.println(depthFirstTraversalRecursive(graph, "A"));
    }
}
