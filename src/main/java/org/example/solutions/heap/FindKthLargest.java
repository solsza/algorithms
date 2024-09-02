package org.example.solutions.heap;

import java.util.PriorityQueue;
import org.example.solutions.DefaultSolution;

public class FindKthLargest implements DefaultSolution {

    public int FindKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);

        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    @Override
    public void runDefaultExample() {
        int[] input1 = new int[] {
            3, 2, 1, 5, 6, 4
        };
        int k1 = 2;
        //Output:5
        int[] input2 = new int[] {
            3, 2, 3, 1, 2, 4, 5, 5, 6
        };
        int k2 = 4;
        //Output:4
        System.out.println(FindKthLargest(input1, k1));
        System.out.println(FindKthLargest(input2, k2));
    }
}
