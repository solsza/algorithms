package org.example.solutions;

import java.util.List;

public class BinarySearch implements DefaultSolution {
    private int binarySearch(List<Integer> list, int key) {
        int lo = 0;
        int hi = list.size() - 1;
        while (lo <= hi) {
            int midIndex = (hi + lo) / 2;
            int midVal = list.get(midIndex);
            if (midVal == key) {
                return midIndex;
            } else if (key > midVal) {
                lo = midIndex + 1;
            } else {
                hi = midIndex - 1;
            }
        }
        return -1;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(binarySearch(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8), 6)); // -> 6
    }
}
