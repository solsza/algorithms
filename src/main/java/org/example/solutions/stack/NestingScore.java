package org.example.solutions.stack;

import org.example.solutions.DefaultSolution;

import java.util.Stack;

public class NestingScore implements DefaultSolution {

    private int nestingScore(String str) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (char ch : str.toCharArray()) {
            if (ch == '[') {
                stack.push(0);
            } else {
                int popped = stack.pop();
                if (popped == 0) {
                    stack.push(stack.pop() + 1);
                } else {
                    stack.push(stack.pop() + 2 * popped);
                }
            }
        }
        return stack.get(0);
    }

    @Override
    public void runDefaultExample() {
        System.out.println(nestingScore("[]"));
        System.out.println(nestingScore("[[]]"));
    }
}
