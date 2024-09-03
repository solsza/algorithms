package org.example.solutions.stack;

import org.example.solutions.DefaultSolution;

public class PairedParentheses implements DefaultSolution {

    private boolean pairedParentheses(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                count += 1;
            } else if (c == ')') {
                if (count > 0) {
                    count -= 1;
                } else {
                    return false;
                }
            }
        }
        return count == 0;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(pairedParentheses("(david)((abby))")); // -> true
        System.out.println(("()rose(jeff")); // -> false
    }
}
