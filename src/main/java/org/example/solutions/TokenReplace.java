package org.example.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TokenReplace implements DefaultSolution {

    private String tokenReplace(String s, Map<String, String> tokens) {
        StringBuilder result = new StringBuilder();
        StringBuilder token = new StringBuilder();
        boolean tokenFound = false;
        for (char c : s.toCharArray()) {
            if (c == '$') {
                if (tokenFound) {
                    tokenFound = false;
                    token.append(c);
                    result.append(tokens.get(token.toString()));
                    token = new StringBuilder();
                } else {
                    tokenFound = true;
                    token.append(c);
                }
            } else {
                if (tokenFound) {
                    token.append(c);
                } else {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    private String tokenReplaceWithPointer(String s, Map<String, String> tokens) {
        List<String> output = new ArrayList<>();
        int i = 0;
        int j = i + 1;
        while (i < s.length()) {
            if (s.charAt(i) != '$') {
                output.add(String.valueOf(s.charAt(i)));
                i++;
                j = i + 1;
            } else if (s.charAt(j) != '$') {
                j++;
            } else {
                String key = s.substring(i, j + 1);
                output.add(tokens.get(key));
                i = j + 1;
                j = i + 1;
            }
        }
        return String.join("", output);
    }

    @Override
    public void runDefaultExample() {
        Map<String, String> tokens = Map.of(
                "$ADJECTIVE$", "quick",
                "$VERB$", "hopped",
                "$DIRECTION$", "North"
        );
        System.out.println(tokenReplaceWithPointer("the $ADJECTIVE$ fox $VERB$ $ADJECTIVE$ly $DIRECTION$", tokens));
        // -> "the quick fox hopped quickly Northward"
    }
}
