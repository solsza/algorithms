package org.example.solutions.search;

import org.example.solutions.DefaultSolution;

public class BinarySearch implements DefaultSolution {

    //return index if element exists else return -1
    public int binarySearch(int[] array, final int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                left = mid + 1;

            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    @Override
    public void runDefaultExample() {
        int[] array = {1,4,5,8,10,12,14};
        System.out.println(binarySearch(array, 8));
    }
}
