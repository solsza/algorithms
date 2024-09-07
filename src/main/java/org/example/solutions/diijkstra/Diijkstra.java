package org.example.solutions.diijkstra;

import org.example.solutions.DefaultSolution;

import java.util.AbstractMap.SimpleEntry;
import java.util.*;

public class Diijkstra implements DefaultSolution {

    private SimpleEntry<List<String>, Integer> calculateShortestPathFromSource(Map<String, List<Edge<String>>> graph, String sourceNode, String targetNode) {
        HashSet<String> visitedNodes = new HashSet<>();
        Map<String, BacktrackEdge<String>> distance = generateBaseDistance(graph, sourceNode);
        PriorityQueue<Edge<String>> queue = new PriorityQueue<>(Comparator.comparing(edge -> edge.weight));
        queue.add(new Edge<>(sourceNode, 0));
        while (!queue.isEmpty() && visitedNodes.size() != graph.size()) {
            Edge<String> currentEdge = queue.poll();
            String currentNode = currentEdge.target;
            if (!visitedNodes.contains(currentNode)) {;
                visitedNodes.add(currentNode);
                for (Edge<String> neighbor : graph.get(currentNode)) {
                    String neighborNode = neighbor.target;
                    int neighborWeight = neighbor.weight;
                    if (!visitedNodes.contains(neighborNode) && distance.get(currentNode).distance + neighborWeight < distance.get(neighborNode).distance) {
                        distance.put(neighborNode, new BacktrackEdge<>(currentNode, distance.get(currentNode).distance + neighborWeight));
                        queue.add(new Edge<>(neighborNode, distance.get(neighborNode).distance));
                    }
                }
            }
        }
        return getPathAndValue(distance, targetNode);
    }

    private Map<String, BacktrackEdge<String>> generateBaseDistance(Map<String, List<Edge<String>>> graph, String sourceNode) {
        Map<String, BacktrackEdge<String>> distance = new HashMap<>();
        for (String node : graph.keySet()) {
            distance.put(node, new BacktrackEdge<String>(null, Integer.MAX_VALUE));
        }
        distance.put(sourceNode, new BacktrackEdge<String>(null, 0));
        return distance;
    }

    private SimpleEntry<List<String>, Integer> getPathAndValue(Map<String, BacktrackEdge<String>> distance, String targetNode) {
        List<String> path = new ArrayList<>();
        path.add(targetNode);
        BacktrackEdge<String> stringBacktrackEdge = distance.get(targetNode);
        while (stringBacktrackEdge != null) {
            if (stringBacktrackEdge.parent != null) {
                path.add(0, stringBacktrackEdge.parent);
            }
            stringBacktrackEdge = distance.get(stringBacktrackEdge.parent);
        }
        return new SimpleEntry<>(path, distance.get(targetNode).distance);
    }

    @Override
    public void runDefaultExample() {
        Map<String, List<Edge<String>>> edges = new HashMap<>();
        edges.computeIfAbsent("A", t -> new ArrayList<>()).add(new Edge("B", 10));
        edges.computeIfAbsent("A", t -> new ArrayList<>()).add(new Edge("C", 15));
        edges.computeIfAbsent("B", t -> new ArrayList<>()).add(new Edge("D", 12));
        edges.computeIfAbsent("B", t -> new ArrayList<>()).add(new Edge("F", 15));
        edges.computeIfAbsent("C", t -> new ArrayList<>()).add(new Edge("E", 10));
        edges.computeIfAbsent("D", t -> new ArrayList<>()).add(new Edge("E", 2));
        edges.computeIfAbsent("D", t -> new ArrayList<>()).add(new Edge("F", 1));
        edges.computeIfAbsent("F", t -> new ArrayList<>()).add(new Edge("E", 5));
        edges.computeIfAbsent("E", t -> new ArrayList<>());
        System.out.println(calculateShortestPathFromSource(edges, "A", "E"));
    }

    static class Edge<T> {
        T target;
        int weight;

        public Edge(T target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    static class BacktrackEdge<T> {
        T parent;
        int distance;

        public BacktrackEdge(T parent, int weight) {
            this.parent = parent;
            this.distance = weight;
        }

        @Override
        public String toString() {
            return parent + ":" + distance;
        }
    }
}
