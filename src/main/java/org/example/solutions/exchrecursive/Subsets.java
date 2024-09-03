package org.example.solutions.exchrecursive;

import org.example.solutions.DefaultSolution;

import java.util.ArrayList;
import java.util.List;

public class Subsets implements DefaultSolution {

    private List<List<String>> subsets(List<String> elements) {
        if (elements.isEmpty()) return List.of(List.of());
        String ele = elements.get(0);
        List<List<String>> subsetsWithoutEle = subsets(elements.subList(1, elements.size()));
        List<List<String>> allSubsets = new ArrayList<>(subsetsWithoutEle);
        for (List<String> subsetWithout : subsetsWithoutEle) {
            List<String> subsetWith = new ArrayList<>(subsetWithout);
            subsetWith.add(ele);
            allSubsets.add(subsetWith);
        }
        return allSubsets;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(subsets(List.of("a", "b", "c")));
        System.out.println(subsets(List.of("a", "b")));
    }
}
