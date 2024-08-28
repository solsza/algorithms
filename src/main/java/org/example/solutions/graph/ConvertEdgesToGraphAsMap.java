package org.example.solutions.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.solutions.DefaultSolution;

public class ConvertEdgesToGraphAsMap implements DefaultSolution {

    public static Map<String, List<String>> convert(List<List<String>> edges) {
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> edge : edges) {
            String firstNode = edge.get(0);
            String secondNode = edge.get(1);
            graph.computeIfAbsent(firstNode, k -> new ArrayList<>()).add(secondNode);
            graph.computeIfAbsent(secondNode, k -> new ArrayList<>()).add(firstNode);
        }
        return graph;
    }

    @Override
    public void runDefaultExample() {
        List<List<String>> edges = new ArrayList<>();
        edges.add(List.of("I", "J"));
        edges.add(List.of("K", "I"));
        edges.add(List.of("M", "K"));
        edges.add(List.of("K", "L"));
        edges.add(List.of("O", "N"));
        System.out.println("Result " + convert(edges));
    }
}
