package org.example.solutions;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring implements DefaultSolution {

    public String minWindow(String s, String t) {
        Map<Character, Integer> current = new HashMap<>();
        Map<Character, Integer> expected = new HashMap<>();

        for (char c : t.toCharArray()) {
            expected.put(c, expected.getOrDefault(c, 0) + 1);
        }

        String result = "";
        int resultLength = Integer.MAX_VALUE;
        int currentValue = 0;
        int expectedValue = expected.size();

        int left = 0;
        for (int r = left; r < s.length(); r++) {
            char c = s.charAt(r);
            if (expected.containsKey(c)) {
                current.put(c, current.getOrDefault(c, 0) + 1);
                if(current.get(c).equals(expected.get(c))) {
                    currentValue++;
                }
                if(currentValue == expectedValue && (resultLength > r - left + 1)) {
                    result = s.substring(left, r + 1);
                    resultLength = result.length();
                }
            }
            while(currentValue == expectedValue) {
                if(current.containsKey(s.charAt(left))) {
                    current.put(s.charAt(left), current.get(s.charAt(left)) - 1);
                    if(current.get(s.charAt(left)) < (expected.get(s.charAt(left)))) {
                        currentValue--;
                    }
                }
                if(currentValue == expectedValue && (resultLength > r - left)) {
                    result = s.substring(left + 1, r + 1);
                    resultLength = result.length();
                }
                left++;
            }
        }
        return result;
    }



    @Override
    public void runDefaultExample() {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minimumWindowSubstring.minWindow("a", "a"));
        System.out.println(minimumWindowSubstring.minWindow("a", "aa"));
        System.out.println(minimumWindowSubstring.minWindow("abcabdebac", "cda"));
    }
}
