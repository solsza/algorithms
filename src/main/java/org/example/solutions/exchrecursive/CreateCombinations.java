package org.example.solutions.exchrecursive;

import org.example.solutions.DefaultSolution;

import java.util.ArrayList;
import java.util.List;

public class CreateCombinations implements DefaultSolution {

    private List<List<String>> createCombinations(List<String> items, int k) {
        if (k == 0) return List.of(List.of());
        if (k > items.size()) return List.of();

        String firsEle = items.get(0);
        List<List<String>> allCombos = new ArrayList<>();
        for (List<String> combo : createCombinations(items.subList(1, items.size()), k - 1)) {
            List<String> newCombo = new ArrayList<>(combo);
            newCombo.add(firsEle);
            allCombos.add(newCombo);
        }
        allCombos.addAll(createCombinations(items.subList(1, items.size()), k));
        return allCombos;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(createCombinations(List.of("a", "b", "c"), 2)); // ->
        // [
        //   [ "a", "b" ],
        //   [ "a", "c" ],
        //   [ "b", "c" ]
        // ]
        System.out.println(createCombinations(List.of("q", "r", "s", "t"), 2)); // ->
        // [
        //   [ "q", "r" ],
        //   [ "q", "s" ],
        //   [ "q", "t" ],
        //   [ "r", "s" ],
        //   [ "r", "t" ],
        //   [ "s", "t" ]
        // ]
    }
}
