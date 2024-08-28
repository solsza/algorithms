package org.example.solutions;

import java.util.HashMap;
import java.util.List;

public class MostFrequentChar implements DefaultSolution {

    private char mostFrequentChar(String s) {
        HashMap<Character, Integer> count = createCount(s);
        char current = s.charAt(0);
        for (char character : s.toCharArray()) {
            if (current != character) {
                int numberOfOccurrence = count.get(character);
                if (numberOfOccurrence > count.get(current)) {
                    current = character;
                }
            }
        }
        return current;
    }

    private HashMap<Character, Integer> createCount(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char character : s.toCharArray()) {
            if (!count.containsKey(character)) {
                count.put(character, 0);
            }
            count.put(character, count.get(character) + 1);
        }
        return count;
    }

    @Override
    public void runDefaultExample() {
        List<String> words = List.of("bookeeper", "david", "abby", "mississippi", "potato", "eleventennine", "riverbed");
        words.forEach(word -> System.out.println(mostFrequentChar(word)));
    }
}
