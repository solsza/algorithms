package org.example.solutions.stack;

import org.example.solutions.DefaultSolution;

import java.util.Map;
import java.util.Stack;

public class BefittingBrackets implements DefaultSolution {

    boolean befittingBrackets(String str) {
        Map<Character, Character> brackets = Map.of(
                '{', '}',
                '(', ')',
                '[', ']'
        );
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (brackets.containsKey(c)) {
                stack.push(brackets.get(c));
            } else {
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    @Override
    public void runDefaultExample() {
        System.out.println(befittingBrackets("(){}[](())")); // -> true
        System.out.println(befittingBrackets("({[]})")); // -> true
    }
}
