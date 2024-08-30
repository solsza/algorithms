package org.example.solutions.graph;

import org.example.solutions.DefaultSolution;

import java.util.*;

public class LongestPath implements DefaultSolution {

    private int longestPath(Map<String, List<String>> graph) {
        HashMap<String, Integer> distance = new HashMap<>();
        for(String node : graph.keySet()) {
            if(graph.get(node).isEmpty()) {
                distance.put(node, 0);
            }
        }
        for(String node : graph.keySet()) {
            traverseDistance(node,graph,distance);
        }
        return Collections.max(distance.values());
    }

    private int traverseDistance(String node, Map<String, List<String>> graph, HashMap<String, Integer> distance) {
        if(distance.containsKey(node)) {
            return distance.get(node);
        }
        int maxDistance = 0;
        for(String neighbor : graph.get(node)) {
            int attemptDistance = traverseDistance(neighbor, graph, distance);
            if(maxDistance < attemptDistance) {
                maxDistance = attemptDistance;
            }
        }
        distance.put(node, maxDistance + 1);
        return 1 + maxDistance;
    }

    @Override
    public void runDefaultExample() {

    }
}
