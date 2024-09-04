package org.example.solutions;

import java.util.ArrayList;
import java.util.List;

public class MergeSortRecursive implements DefaultSolution {

    private List<Integer> mergeSort(List<Integer> nums) {
        if (nums.size() <= 1) {
            return nums;
        }
        int midIdx = nums.size() / 2;
        List<Integer> left = nums.subList(0, midIdx);
        List<Integer> right = nums.subList(midIdx, nums.size());
        List<Integer> sortedLeft = mergeSort(left);
        List<Integer> sortedRight = mergeSort(right);
        return merge(sortedLeft, sortedRight);
    }

    public static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> merged = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                merged.add(list1.get(i));
                i += 1;
            } else {
                merged.add(list2.get(j));
                j += 1;
            }
        }
        merged.addAll(list1.subList(i, list1.size()));
        merged.addAll(list2.subList(j, list2.size()));
        return merged;
    }

    @Override
    public void runDefaultExample() {
        List<Integer> numbers = List.of(10, 4, 42, 5, 8, 100, 5, 6, 12, 40);
        System.out.println(mergeSort(numbers));
        // -> [ 4, 5, 5, 6, 8, 10, 12, 40, 42, 100 ]
    }
}
