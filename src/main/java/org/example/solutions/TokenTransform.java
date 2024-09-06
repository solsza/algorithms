package org.example.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TokenTransform implements DefaultSolution {

    private String tokenTransform(String s, Map<String, String> tokens) {
        List<String> output = new ArrayList<>();
        int i = 0;
        int j = 1;
        while (i < s.length()) {
            if (s.charAt(i) != '$') {
                output.add(Character.toString(s.charAt(i)));
                i += 1;
                j = i + 1;
            } else if (s.charAt(j) != '$') {
                j += 1;
            } else {
                String key = s.substring(i, j + 1);
                String evaluatedValue = tokenTransform(tokens.get(key), tokens);
                output.add(evaluatedValue);
                i = j + 1;
                j = i + 1;
            }
        }
        return String.join("", output);
    }

    @Override
    public void runDefaultExample() {
        Map<String, String> tokens = Map.of(
                "$ADJECTIVE_1$", "quick",
                "$ADJECTIVE_2$", "eager",
                "$ADVERBS$", "$ADJECTIVE_1$ly and $ADJECTIVE_2$ly",
                "$VERB$", "hopped $DIRECTION$",
                "$DIRECTION$", "North"
        );
        System.out.println(tokenTransform("the $ADJECTIVE_1$ fox $ADVERBS$ $VERB$ward, tokens", tokens));
        // -> "the quick fox hopped quickly Northward"
    }
}
