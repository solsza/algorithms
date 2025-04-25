package org.example.solutions.two_pointer;

import org.example.solutions.DefaultSolution;

public class IsPalindrome implements DefaultSolution {

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(isPalindrome("pop"));
        System.out.println(isPalindrome("abcbca"));
        System.out.println(isPalindrome(""));
    }
}
