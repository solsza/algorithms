package org.example.solutions.sorts;

import java.util.Arrays;
import java.util.Random;
import org.example.solutions.DefaultSolution;

public class BubbleSort implements DefaultSolution {

    private int[] bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    swap(numbers, j, j + 1);
                }
            }
        }
        return numbers;
    }

    private int[] optimalBubbleSort(int[] numbers) {
        int n = numbers.length;
        int i = 0;
        boolean swapped = true;
        while (i < n - 1 && swapped) {
            swapped = false;
            for (int j = i + 1; j < n; j++) {
                if (numbers[j] < numbers[j - 1]) {
                    swap(numbers, j, j - 1);
                    swapped = true;
                }
            }
            i++;
        }
        return numbers;
    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }


    @Override
    public void runDefaultExample() {
        Random rand = new Random();
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }
        System.out.println(Arrays.toString(bubbleSort(numbers)));
        System.out.println(Arrays.toString(optimalBubbleSort(numbers)));
    }


}
