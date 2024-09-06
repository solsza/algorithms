package org.example.solutions;

public class LexicalOrder implements DefaultSolution {

    private boolean lexicalOrder(String word1, String word2, String alphabet) {
        for (int i = 0; i < Math.max(word1.length(), word2.length()); i += 1) {
            char char1 = i < word1.length() ? word1.charAt(i) : '\0';
            char char2 = i < word2.length() ? word2.charAt(i) : '\0';
            int value1 = alphabet.indexOf(char1);
            int value2 = alphabet.indexOf(char2);
            if (value1 < value2) {
                return true;
            } else if (value1 > value2) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void runDefaultExample() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(lexicalOrder("apple", "dock", alphabet)); // -> true
        String alphabet1 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(lexicalOrder("apple", "ample", alphabet1)); // -> false
    }
}
