package org.example.solutions.graph;

import org.example.solutions.DefaultSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PrereqsPossible implements DefaultSolution {

    private boolean prereqsPossible(int numCourses, List<List<Integer>> prereqs) {
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, List<Integer>> graph = buildGraph(numCourses, prereqs);
        for (int node : graph.keySet()) {
            if (hasCycle(node, graph, new HashSet<>(), visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int node, HashMap<Integer, List<Integer>> graph, HashSet<Integer> visiting, HashSet<Integer> visited) {
        if (visited.contains(node)) {
            return false;
        }
        if (visiting.contains(node)) {
            return true;
        }
        visiting.add(node);
        for (int neighbor : graph.get(node)) {
            if (hasCycle(neighbor, graph, visiting, visited)) {
                return true;
            }
        }
        visiting.remove(node);
        visited.add(node);
        return false;
    }

    private HashMap<Integer, List<Integer>> buildGraph(int numCourses, List<List<Integer>> prereqs) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i += 1) {
            graph.put(i, new ArrayList<>());
        }

        for (List<Integer> pair : prereqs) {
            int courseA = pair.get(0);
            int courseB = pair.get(1);
            graph.get(courseA).add(courseB);
        }

        return graph;
    }

    @Override
    public void runDefaultExample() {
        int numCourses = 6;
        List<List<Integer>> prereqs = List.of(
                List.of(0, 1),
                List.of(2, 3),
                List.of(0, 2),
                List.of(1, 3),
                List.of(4, 5)
        );
        System.out.println(prereqsPossible(numCourses, prereqs)); // -> true
    }
}
