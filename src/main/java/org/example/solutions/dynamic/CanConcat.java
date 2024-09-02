package org.example.solutions.dynamic;

import org.example.solutions.DefaultSolution;

import java.util.HashMap;
import java.util.List;

public class CanConcat implements DefaultSolution {

    private boolean canConcat(String s, List<String> words) {
        return canConcat(s, words, new HashMap<>());
    }

    private boolean canConcat(String s, List<String> words, HashMap<String, Boolean> memo) {
        if (s.isEmpty()) return true;
        if (memo.containsKey(s)) return memo.get(s);
        for (String word : words) {
            if (s.startsWith(word)) {
                if (canConcat(s.substring(word.length()), words, memo)) {
                    memo.put(s, true);
                    return true;
                }
            }
        }
        memo.put(s, false);
        return false;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(canConcat("oneisnone", List.of("one", "none", "is"))); // -> true
        System.out.println(canConcat("oneisnone", List.of("on", "e", "is"))); // -> false
    }
}
