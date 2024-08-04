package org.example.solutions;

public class LengthOfLastWord implements DefaultSolution {

    public int lengthOfLastWord(String s) {
        char[] words = s.toCharArray();
        int length = words.length;

        int j = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (words[i] != ' ') {
                j++;
            }
            if (words[i] == ' ' && j > 0) {
                return j;
            }
        }
        return j;
    }

    @Override
    public void runDefaultExample() {
        LengthOfLastWord solution = new LengthOfLastWord();
        System.out.println(solution.lengthOfLastWord("Hello World"));
        System.out.println(solution.lengthOfLastWord("Hello World  "));
        System.out.println(solution.lengthOfLastWord(" Hello  World  "));
    }
}
