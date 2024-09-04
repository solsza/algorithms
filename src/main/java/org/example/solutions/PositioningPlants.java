package org.example.solutions;

import java.util.HashMap;
import java.util.List;

public class PositioningPlants implements DefaultSolution {

    private int positioningPlants(List<List<Integer>> costs) {
        return positioningPlants(costs, 0, -1, new HashMap<>());
    }

    private int positioningPlants(List<List<Integer>> costs, int pos, int prevPlantIdx, HashMap<List<Integer>, Integer> memo) {
        List<Integer> key = List.of(pos, prevPlantIdx);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (pos == costs.size()) {
            return 0;
        }
        int minCost = -1;
        for (int plantIdx = 0; plantIdx < costs.get(pos).size(); plantIdx += 1) {
            if (plantIdx != prevPlantIdx) {
                int candidateCost = costs.get(pos).get(plantIdx) + positioningPlants(costs, pos + 1, plantIdx, memo);
                if (minCost == -1 || candidateCost < minCost) {
                    minCost = candidateCost;
                }
            }
        }
        memo.put(key, minCost);
        return minCost;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(positioningPlants(List.of(
            List.of(4, 3, 7),
            List.of(6, 1, 9),
            List.of(2, 5, 3)
        ))); // -> 7, by doing 4 + 1 + 2.
        System.out.println(positioningPlants(List.of(
            List.of(12, 14, 5),
            List.of(6, 3, 2)
        ))); // -> 7, by doing 4 + 1 + 2.
    }
}
