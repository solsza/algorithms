package org.example.solutions;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

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
}
