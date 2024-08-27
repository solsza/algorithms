package org.example.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FiveSort implements DefaultSolution {

    private List<Integer> fiveSort(List<Integer> array) {
        int i = 0;
        int j = array.size() - 1;
        while (i < j) {
            if (array.get(j) == 5) {
                j--;
            } else if (array.get(i) != 5) {
                i++;
            } else {
                Collections.swap(array, i, j);
            }
        }
        return array;
    }

    private void swap (List<Integer> array, int i, int j) {}

    @Override
    public void runDefaultExample() {
        System.out.println(fiveSort(new ArrayList<>(List.of(12, 5, 1, 5, 12, 7))));
        System.out.println(fiveSort(new ArrayList<>(List.of(5, 2, 5, 6, 5, 1, 10, 2, 5, 5))));
        System.out.println(fiveSort(new ArrayList<>(List.of(5, 5, 5, 1, 1, 1, 4))));
        System.out.println(fiveSort(new ArrayList<>(List.of(5, 5, 6, 5, 5, 5, 5))));
    }
}
