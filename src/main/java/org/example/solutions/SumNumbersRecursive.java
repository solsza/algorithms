package org.example.solutions;

import java.util.List;

public class SumNumbersRecursive implements DefaultSolution{

    private int sumNumbersRecursive (List<Integer> elements) {
        return sumElementsRecursive(elements, 0, 0);
    }

    private int sumElementsRecursive(List<Integer> elements, int pointer, int sum) {
        if(pointer > elements.size() - 1) {
            return sum;
        }
        sum += elements.get(pointer);
        pointer ++;
        return sumElementsRecursive(elements, pointer, sum);
    }


    @Override
    public void runDefaultExample() {
        System.out.println(sumNumbersRecursive(List.of(5, 2, 9, 10)));
        System.out.println(sumNumbersRecursive(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));
        System.out.println(sumNumbersRecursive(List.of(123456789, 12345678, 1234567, 123456, 12345, 1234, 123, 12, 1, 0)));
    }
}
