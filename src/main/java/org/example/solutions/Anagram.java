package org.example.solutions;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Anagram implements DefaultSolution {

    private boolean anagram(String s1, String s2) {
        return charCount(s1).equals(charCount(s2));
    }

    private HashMap<Character, Integer> charCount(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!count.containsKey(c)) {
                count.put(c, 0);
            }
            count.put(c, count.get(c) + 1);
        }
        return count;
    }


    @Override
    public void runDefaultExample() {
        List<SimpleEntry<String, String>> words = new ArrayList<>();
        words.add(new SimpleEntry<>("restful", "fluster"));
        words.add(new SimpleEntry<>("cats", "tocs"));
        words.add(new SimpleEntry<>("monkeyswrite", "newyorktimes"));
        words.add(new SimpleEntry<>("paper", "reapa"));
        words.forEach(wordPair -> {
            System.out.println(anagram(wordPair.getKey(), wordPair.getValue()));
        });
    }
}
