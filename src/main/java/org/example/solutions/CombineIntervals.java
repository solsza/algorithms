package org.example.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CombineIntervals implements DefaultSolution {

    private List<List<Integer>> combineIntervals(List<List<Integer>> intervals) {
        List<List<Integer>> sortedIntervals = new ArrayList<>(intervals);
        Collections.sort(sortedIntervals, new SortByIntervalStart());
        List<List<Integer>> combined = new ArrayList<>();
        combined.add(new ArrayList<>(sortedIntervals.get(0)));

        for (List<Integer> currentInterval : sortedIntervals.subList(1, sortedIntervals.size())) {
            List<Integer> lastInterval = combined.get(combined.size() - 1);
            int lastEnd = lastInterval.get(1);
            int currentStart = currentInterval.get(0);
            int currentEnd = currentInterval.get(1);

            if (currentStart <= lastEnd) {
                if (currentEnd > lastEnd) {
                    lastInterval.set(1, currentEnd);
                }
            } else {
                combined.add(new ArrayList<>(currentInterval));
            }
        }
        return combined;
    }

    @Override
    public void runDefaultExample() {
        List<List<Integer>> intervals = List.of(
            List.of(3, 7),
            List.of(10, 13),
            List.of(5, 8),
            List.of(27, 31),
            List.of(1, 5),
            List.of(12, 16),
            List.of(20, 22)
        );
        System.out.println(combineIntervals(intervals));
    }
}

class SortByIntervalStart implements Comparator<List<Integer>> {
    public int compare(List<Integer> intervalA, List<Integer> intervalB) {
        return intervalA.getFirst() - intervalB.getFirst();
    }
}
