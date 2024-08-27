package org.example.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Insertions implements DefaultSolution {

    private List<Integer> intersection(List<Integer> listA, List<Integer> listB) {
        List<Integer> intersection = new ArrayList<>();
        HashSet<Integer> toCompare = new HashSet<>(listA);
        for (int value : listB) {
            if (toCompare.contains(value)) {
                intersection.add(value);
            }
        }
        return intersection;
    }

    @Override
    public void runDefaultExample() {
        List<Integer> a = List.of(4, 2, 1, 6);
        List<Integer> b = List.of(3, 6, 9, 2, 10);
        System.out.println(intersection(a, b));
    }
}
