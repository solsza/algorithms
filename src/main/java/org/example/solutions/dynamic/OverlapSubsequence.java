package org.example.solutions.dynamic;

import org.example.solutions.DefaultSolution;

import java.util.HashMap;
import java.util.List;

public class OverlapSubsequence implements DefaultSolution {

    private int overlapSubsequence(String str1, String str2) {
        return overlapSubsequence(str1, str2, 0, 0, new HashMap<>());
    }

    private int overlapSubsequence(String str1, String str2, int i, int j, HashMap<List<Integer>, Integer> memo) {
        if (i == str1.length() || j == str2.length()) {
            return 0;
        }

        List<Integer> key = List.of(i, j);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int result;
        if (str1.charAt(i) == str2.charAt(j)) {
            result = 1 + overlapSubsequence(str1, str2, i + 1, j + 1, memo);
        } else {
            result = Math.max(
                    overlapSubsequence(str1, str2, i + 1, j, memo),
                    overlapSubsequence(str1, str2, i, j + 1, memo)
            );
        }
        memo.put(key, result);
        return result;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(overlapSubsequence("dogs", "daogt")); // -> 3
        System.out.println(overlapSubsequence(
                "mumblecorebeardleggingsauthenticunicorn",
                "succulentspughumblemeditationlocavore"
        )); // -> 15
    }
}
