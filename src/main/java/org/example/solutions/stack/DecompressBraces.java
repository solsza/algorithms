package org.example.solutions.stack;

import org.example.solutions.DefaultSolution;

import java.util.Stack;

public class DecompressBraces implements DefaultSolution {

    private String decompressBraces(String str) {
        String numbers = "123456789";
        Stack<String> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch != '}') {
                if (ch != '{') stack.push(String.valueOf(ch));
            } else {
                StringBuilder segment = new StringBuilder();
                while (!numbers.contains(stack.peek())) segment.insert(0,stack.pop());
                int number = Integer.parseInt(stack.pop());
                stack.push(segment.toString().repeat(number));
            }
        }
        return String.join("", stack);
    }

    @Override
    public void runDefaultExample() {
        System.out.println(decompressBraces("2{q}3{tu}v"));
        System.out.println(decompressBraces("ch3{ao}"));
        System.out.println(decompressBraces("3{al4{ec}2{icia}}"));
    }
}
