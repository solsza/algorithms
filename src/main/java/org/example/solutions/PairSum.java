package org.example.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PairSum implements DefaultSolution {

    List<Integer> pairSum(List<Integer> numbers, int target) {
        HashMap<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (visited.containsKey(numbers.get(i))) {
                return List.of(visited.get(numbers.get(i)), i);
            } else {
                int expectedValue = target - numbers.get(i);
                visited.put(expectedValue, i);
            }
        }
        return new ArrayList<>();
    }


    @Override
    public void runDefaultExample() {
        System.out.println(pairSum(List.of(3, 2, 5, 4, 1), 8));
        System.out.println(pairSum(List.of(4, 7, 9, 2, 5, 1), 5));
        System.out.println(pairSum(List.of(4, 7, 9, 2, 5, 1), 3));
        System.out.println(pairSum(List.of(1, 6, 7, 2), 13));
        System.out.println(pairSum(List.of(9, 9), 18));
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 25000; i += 1) {
            numbers.add(i);
        }
        System.out.println(pairSum(numbers, 49999));
    }
}
