package org.example.solutions.two_pointer;

import org.example.solutions.DefaultSolution;

public class IsSubsequence implements DefaultSolution {

    public static boolean isSubsequence(String string1, String string2) {
        int i = 0;
        int j = 0;
        while (i < string1.length() && j < string2.length()) {
            if (string1.charAt(i) == string2.charAt(j)) {
                i += 1;
                j += 1;
            } else {
                j += 1;
            }
        }
        return i == string1.length();
    }

    @Override
    public void runDefaultExample() {
        System.out.println(isSubsequence("bde", "abcdef"));
        System.out.println(isSubsequence("bda", "abcdef"));
        System.out.println(isSubsequence("ser", "super"));
    }
}
