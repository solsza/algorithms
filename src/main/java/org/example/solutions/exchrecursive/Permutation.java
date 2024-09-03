package org.example.solutions.exchrecursive;

import org.example.solutions.DefaultSolution;

import java.util.ArrayList;
import java.util.List;

public class Permutation implements DefaultSolution {

    private List<List<String>> permutations(List<String> elements) {
        if (elements.isEmpty()) return List.of(List.of());
        String firstEle = elements.get(0);
        List<List<String>> allPermutations = new ArrayList<>();
        List<List<String>> subPerms = permutations(elements.subList(1, elements.size()));
        for (List<String> subPerm : subPerms) {
            for (int i = 0; i <= subPerm.size(); i++) {
                List<String> left = subPerm.subList(0, i);
                List<String> right = subPerm.subList(i, subPerm.size());
                ArrayList<String> newPerm = new ArrayList<>(left);
                newPerm.add(firstEle);
                newPerm.addAll(right);
                allPermutations.add(newPerm);
            }
        }
        return allPermutations;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(permutations(List.of("a", "b", "c"))); // ->
        // [
        //   [ "a", "b", "c" ],
        //   [ "b", "a", "c" ],
        //   [ "b", "c", "a" ],
        //   [ "a", "c", "b" ],
        //   [ "c", "a", "b" ],
        //   [ "c", "b", "a" ]
        // ]
    }
}
