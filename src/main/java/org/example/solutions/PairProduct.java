package org.example.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PairProduct implements DefaultSolution {

    private List<Integer> pairProduct(List<Integer> numbers, int target) {
        HashMap<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            int currentValue = numbers.get(i);
            if (target % currentValue == 0) {
                if (visited.containsKey(currentValue)) {
                    return List.of(visited.get(currentValue), i);
                } else {
                    visited.put(target / currentValue, i);
                }
            }
        }
        return List.of();
    }

    @Override
    public void runDefaultExample() {
        System.out.println(pairProduct(List.of(3, 2, 5, 4, 1), 8));
        System.out.println(pairProduct(List.of(3, 2, 5, 4, 1), 10));
        System.out.println(pairProduct(List.of(4, 7, 9, 2, 5, 1), 5));
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 25000; i += 1) {
            numbers.add(i);
        }
        System.out.println(pairProduct(numbers, 624975000));
    }
}
