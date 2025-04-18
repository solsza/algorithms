package org.example;

import java.util.ArrayList;
import java.util.List;
import org.example.solutions.DefaultSolution;

public class Pairs implements DefaultSolution  {

    public static List<List<String>> pairs(List<String> elements) {
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < elements.size(); i += 1) {
            for (int j = i + 1; j < elements.size(); j += 1) {
                List<String> pair = List.of(elements.get(i), elements.get(j));
                result.add(pair);
            }
        }
        return result;
    }

    @Override
    public void runDefaultExample() {

    }
}
