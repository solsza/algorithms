package org.example.solutions.graph;

import org.example.solutions.DefaultSolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SemesterRequired implements DefaultSolution {

    private int semestersRequired(int numCourses, List<List<Integer>> prereqs) {
        HashMap<Integer, List<Integer>> graph = buildGraph(numCourses, prereqs);
        HashMap<Integer, Integer> distance = new HashMap<>();

        for (int node : graph.keySet()) {
            traverseDistance(node, graph, distance);
        }

        return Collections.max(distance.values());
    }

    private int traverseDistance(int node, HashMap<Integer, List<Integer>> graph, HashMap<Integer, Integer> distance) {
        if (distance.containsKey(node)) {
            return distance.get(node);
        }

        int max = 0;
        for (int neighbor : graph.get(node)) {
            int neighborDistance = traverseDistance(neighbor, graph, distance);
            if (neighborDistance > max) {
                max = neighborDistance;
            }
        }

        distance.put(node, max + 1);
        return max + 1;
    }

    private HashMap<Integer, List<Integer>> buildGraph(int numCourses, List<List<Integer>> prereqs) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int node = 0; node < numCourses; node += 1) {
            graph.put(node, new ArrayList<>());
        }

        for (List<Integer> prereq : prereqs) {
            int a = prereq.get(0);
            int b = prereq.get(1);
            graph.get(a).add(b);
        }

        return graph;
    }

    @Override
    public void runDefaultExample() {
        int numCourses = 6;
        List<List<Integer>> prereqs = List.of(
                List.of(1, 2),
                List.of(2, 4),
                List.of(3, 5),
                List.of(0, 5)
        );
        int numCourses1 = 3;
        List<List<Integer>> prereqs1 = List.of(
                List.of(0, 2),
                List.of(0, 1),
                List.of(1, 2)
        );
        System.out.println(semestersRequired(numCourses, prereqs));
        System.out.println(semestersRequired(numCourses1, prereqs1));
    }
}
