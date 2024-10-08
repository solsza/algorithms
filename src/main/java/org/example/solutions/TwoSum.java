package org.example.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum implements DefaultSolution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int expectedValue = target - nums[i];
            if (map.containsKey(expectedValue)) {
                return new int[]{map.get(expectedValue), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public void runDefaultExample() {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
    }
}
