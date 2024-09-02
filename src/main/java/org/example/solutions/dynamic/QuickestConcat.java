package org.example.solutions.dynamic;

import org.example.solutions.DefaultSolution;

import java.util.HashMap;
import java.util.List;

public class QuickestConcat implements DefaultSolution {

    private int quickestConcat(String s, List<String> words) {
        double result = quickestConcat(s, words, new HashMap<>());
        if (result == Double.POSITIVE_INFINITY) {
            return -1;
        } else {
            return (int) result;
        }
    }

    private double quickestConcat(String s, List<String> words, HashMap<String, Double> memo) {
        if (s.isEmpty()) return 0;
        if (memo.containsKey(s)) return memo.get(s);
        double min = Double.POSITIVE_INFINITY;
        for (String word : words) {
            if (s.startsWith(word)) {
                String suffix = s.substring(word.length());
                double attempt = 1 + quickestConcat(suffix, words, memo);
                if (attempt < min) {
                    min = attempt;
                }
            }
        }
        memo.put(s, min);
        return min;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(quickestConcat("caution", List.of("ca", "ion", "caut", "ut")));
        System.out.println(quickestConcat("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu", List.of("u", "uu", "uuu", "uuuu", "uuuuu")));
    }
}
