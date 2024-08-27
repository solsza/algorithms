package org.example.solutions;

import java.util.List;

public class SumOfLengths implements DefaultSolution {

    private int sumOfLengths(List<String> strings) {
        return sumElement(strings, 0, 0);
    }

    private int sumElement(List<String> strings, int elementToCalculateIndex, int sum) {
        if (strings.size() - 1 < elementToCalculateIndex) {
            return sum;
        }
        sum += strings.get(elementToCalculateIndex).length();
        return sumElement(strings, elementToCalculateIndex + 1, sum);
    }

    @Override
    public void runDefaultExample() {
        System.out.println(sumOfLengths(List.of("goat", "cat", "purple")));
        System.out.println(sumOfLengths(List.of("bike", "at", "pencils", "phone")));
        System.out.println(sumOfLengths(List.of()));
        System.out.println(sumOfLengths(List.of("", " ", "  ", "   ", "    ", "     ")));
        System.out.println(sumOfLengths(List.of("0", "313", "1234567890")));
    }
}
