package org.example.solutions;

import java.util.ArrayList;
import java.util.List;

public class Prerequisites implements DefaultSolution {

    public List<String> generateParenthesis(int n) {
        //its backtracking question, so we can create decision tree
        //we have some conditions:
        // only add open prerequisites if open < n
        // only add a closing prerequisites if closed < open
        // ending open == close == n
        List<String> result = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        generateParenthesisHelper(0, 0, n, result, stack);
        return result;

    }

    public void generateParenthesisHelper(int openN, int closedN, int n, List<String> response, StringBuilder stack) {
        if(openN == closedN && openN == n) {
            response.add(stack.toString());
            return;
        }

        if(openN < n) {
            stack.append("(");
            generateParenthesisHelper(openN + 1, closedN, n, response, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
        if(closedN < openN) {
            stack.append(")");
            generateParenthesisHelper(openN, closedN + 1, n, response, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }


    @Override
    public void runDefaultExample() {
        System.out.println(generateParenthesis(3));

    }
}
