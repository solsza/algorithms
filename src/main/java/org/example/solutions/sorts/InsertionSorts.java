package org.example.solutions.sorts;

import java.util.Arrays;
import java.util.Random;
import org.example.solutions.DefaultSolution;

public class InsertionSorts implements DefaultSolution {

    private int[] insertionSort(int[] numbers) {

        for (int i = 1; i < numbers.length; i++) {
            int temp = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] > temp) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = temp;
            i++;
        }
        return numbers;
    }

    @Override
    public void runDefaultExample() {
        Random rand = new Random();
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }
        System.out.println(Arrays.toString(insertionSort(numbers)));
    }

}
