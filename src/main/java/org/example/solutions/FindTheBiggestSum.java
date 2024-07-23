package org.example.solutions;

import java.util.HashMap;
import java.util.Map;

public class FindTheBiggestSum implements DefaultSolution {

    public int findTheBiggestSum(int[] A) {
        if (A.length == 0) return -1;

        Map<Integer, Integer> map = new HashMap<>();
        int sum = -1;

        for (int j : A) {
            int lastDigit = j % 10;
            int firstDigit = getFirstDigit(j);
            int key = firstDigit * 10 + lastDigit;

            if (map.containsKey(key)) {
                int nextSum = j + map.get(key);
                if (nextSum > sum) {
                    sum = nextSum;
                }
                if (j > map.get(key)) {
                    map.put(key, j);
                }
            } else {
                map.put(key, j);
            }
        }
        return sum;
    }

    private int getFirstDigit(int num) {
        int first = 0;
        for (int i = 10; i <= num; i *= 10) {
            first = num / i;
        }
        return first;
    }

    public void runDefaultExample() {
        System.out.println(findTheBiggestSum(new int[]{130, 10, 150, 140}));
        System.out.println(findTheBiggestSum(new int[]{405, 45, 300, 300}));
        System.out.println(findTheBiggestSum(new int[]{50, 222, 49, 52, 25}));
        System.out.println(findTheBiggestSum(new int[]{30, 909, 3190, 99, 3990, 9009}));
        System.out.println(findTheBiggestSum(new int[]{3, 9, 1, 2, 3, 4}));
    }
}
