package org.example.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses implements DefaultSolution {

    Map<Character, Character> map = new HashMap<>();

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else if (st.empty()) {
                return false;
            } else if (st.peek() == '(' && c == ')' && !st.isEmpty()) {
                st.pop();
            } else if (st.peek() == '[' && c == ']' && !st.isEmpty()) {
                st.pop();
            } else if (st.peek() == '{' && c == '}' && !st.isEmpty()) {
                st.pop();
            } else {
                return false;
            }
        }
        return st.isEmpty();
    }

    public boolean isValidSecondSolution(String s) {

        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsValue(c)) {
                top = i;
            } else {
                if (top == -1 || map.get(c) != s.charAt(top)) {
                    return false;
                } else {
                    top = getTop(s, top - 1);
                }
            }
        }

        return top == -1;
    }

    private int getTop(String s, int index) {
        int right = 0;
        while (index >= 0) {
            char ch = s.charAt(index);
            if (map.containsKey(ch)) {
                right++;
            } else {
                right--;
            }

            if (right < 0) {
                return index;
            }
            index--;
        }

        return -1;
    }

    public boolean isValidThirdSolution(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        char[] sCharArray = s.toCharArray();
        int[] expectedValues = new int[s.length()];
        int pointer = -1;

        for (int i = 0; i < s.length(); i++) {
            if (sCharArray[i] == '(') {
                pointer++;
                expectedValues[pointer] = sCharArray[i] + 1;
            } else if (sCharArray[i] == '{') {
                pointer++;
                expectedValues[pointer] = sCharArray[i] + 2;
            } else if (sCharArray[i] == '[') {
                pointer++;
                expectedValues[pointer] = sCharArray[i] + 2;
            } else {
                if (pointer == -1) {
                    return false;
                } else if (expectedValues[pointer] != sCharArray[i]) {
                    return false;
                }
                pointer--;
            }
        }
        return pointer == -1;
    }


    public void runDefaultExample() {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValidSecondSolution("()[]{}"));
        System.out.println(isValidThirdSolution("()[]{}"));
    }
}




