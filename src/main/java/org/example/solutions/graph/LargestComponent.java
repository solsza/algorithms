package org.example.solutions.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.example.solutions.DefaultSolution;

public class LargestComponent implements DefaultSolution {

    int largestComponent(Map<Integer, List<Integer>> graph) {
        HashSet<Integer> visitedNodes = new HashSet<>();
        int maxSize = 0;
        for (Integer node : graph.keySet()) {
            int size = traverseSize(graph, node, visitedNodes);
            if (size > maxSize) {
                maxSize = size;
            }
        }
        return maxSize;
    }

    int traverseSize(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
        if (visited.contains(node)) {
            return 0;
        }
        visited.add(node);
        int count = 1;
        for (Integer neighbor : graph.get(node)) {
            count += traverseSize(graph, neighbor, visited);
        }
        return count;
    }

    @Override
    public void runDefaultExample() {
        int zeroCase = largestComponent(Map.of(
            0, List.of(8, 1, 5),
            1, List.of(0),
            5, List.of(0, 8),
            8, List.of(0, 5),
            2, List.of(3, 4),
            3, List.of(2, 4),
            4, List.of(3, 2)
        ));
        int firstCase = largestComponent(Map.of(
            1, List.of(2),
            2, List.of(1, 8),
            6, List.of(7),
            9, List.of(8),
            7, List.of(6, 8),
            8, List.of(9, 7, 2)
        ));
        int secondCase = largestComponent(Map.of(3, List.of(),
            4, List.of(6),
            6, List.of(4, 5, 7, 8),
            8, List.of(6),
            7, List.of(6),
            5, List.of(6),
            1, List.of(2),
            2, List.of(1)));
        int thirdCase = largestComponent(Map.of());
        int fourthCase = largestComponent(Map.of(
            0, List.of(4, 7),
            1, List.of(),
            2, List.of(),
            3, List.of(6),
            4, List.of(0),
            6, List.of(3),
            7, List.of(0),
            8, List.of()
        ));
        System.out.println("0 :" + zeroCase);
        System.out.println("1 :" + firstCase);
        System.out.println("2 :" + secondCase);
        System.out.println("3 :" + thirdCase);
        System.out.println("4 :" + fourthCase);
    }
}
