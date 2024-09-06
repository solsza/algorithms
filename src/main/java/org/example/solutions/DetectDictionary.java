package org.example.solutions;

import java.util.List;

public class DetectDictionary implements DefaultSolution {

    private boolean detectDictionary(List<String> dictionary, String alphabet) {
        for (int i = 0; i < dictionary.size() - 1; i += 1) {
            String word1 = dictionary.get(i);
            String word2 = dictionary.get(i + 1);
            if (!lexicalOrder(word1, word2, alphabet)) return false;
        }
        return true;
    }

    private boolean lexicalOrder(String word1, String word2, String alphabet) {
        for (int i = 0; i < Math.max(word1.length(), word2.length()); i += 1) {
            char char1 = i < word1.length() ? word1.charAt(i) : '\0';
            char char2 = i < word2.length() ? word2.charAt(i) : '\0';
            int value1 = alphabet.indexOf(char1);
            int value2 = alphabet.indexOf(char2);

            if (value1 < value2) return true;
            else if (value1 > value2) return false;
        }
        return true;
    }


    @Override
    public void runDefaultExample() {

    }
}
