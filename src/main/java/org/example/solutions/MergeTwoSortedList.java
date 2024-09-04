package org.example.solutions;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedList implements DefaultSolution {

    private List<Integer> mergeTwoSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<Integer>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            }
            else {
                mergedList.add(list2.get(j));
                j++;
            }
        }
        mergedList.addAll(list1.subList(i, list1.size()));
        mergedList.addAll(list2.subList(j, list2.size()));
        return mergedList;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(mergeTwoSortedLists(List.of(3, 4, 5), List.of(2, 8, 9)));
    }
}
