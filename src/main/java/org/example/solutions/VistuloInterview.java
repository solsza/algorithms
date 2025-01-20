package org.example.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VistuloInterview {

    public static List<Integer> processArray(int[] input) {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if(input[i] < 0) {
                result.put(i + 1, input[i]);
            }
            else {
                result.remove(input[i]);
            }
        }
        return new ArrayList<>(result.values());
    }


/*
It will work for example input. And complexity of solution is O(n)
But I am not sure about this solution, because let's consider example like this:
[-1, -2, -3, 2, -5, 5]
What should happen after removing element?
    -> in current solution when we get number 2 -> program remove -2 like second element (* index = 1)
   after this action I have hashMap like that (1, -1), (3, -3), we lose index number 2.
   So should I recalculate indexes? In this case after removing program should have hashMap like this:
   (1, -1), (2, -3)
 */

/* Solution 2 with index recalculation*/

public static List<Integer> processArrayWithRecalculation(int[] input) {
    HashMap<Integer, Integer> result = new HashMap<>();
    for (int i = 0; i < input.length; i++) {
        if(input[i] < 0) {
            result.put(i + 1, input[i]);
        }
        else {
            result.remove(input[i]);
            recalculateIndexes(result, input[i]);
        }
    }
    return new ArrayList<>(result.values());
}
public static void recalculateIndexes(HashMap<Integer, Integer> result, int input) {
    for (int i = input; i <= result.size(); i++) {
        Integer i1 = result.get(i + 1);
        if(i1 != null) {
            result.remove(i + 1);
            result.put(i, i1);
        }
    }
}

//After checking this solution I understood that it is not the correct way because I do not think that index will change,
//so I try to figure out another  solution and I think the best one will be recursive
//so lets try to explain this:
// e.g. input [-1,-2, -3, 2, 2, -5, -2 ,-4]
// Main condition if index > input.length -> program should stop calculating numbers
// if number is < 0 add number to result
//if not and it not out of bounds of result remove element from array or go to next calculation
// for [-1, -2 , -3] -> save to result
// for [2] -> remove -2
// do this till get last element from input.


    public static List<Integer> recursiveOne(int[] input) {
        List<Integer> result = new ArrayList<>();
        recursiveSolution(result, input, 0);
        return result;
    }

    public static void recursiveSolution(List<Integer> result, int[] input, int index) {
        if(index > input.length - 1) {
            return;
        }
        else {
            int currentValue = input[index];
            if (currentValue < 0) {
                result.add(currentValue);
                recursiveSolution(result, input, index + 1);
            } else {
                if (currentValue != 0 && currentValue <= result.size()) {
                    //in this solution will be recalculation
                    int calculateIndex = currentValue - 1;
                    result.remove(calculateIndex);
                    recursiveSolution(result, input, index + 1);
                }
                else {
                    recursiveSolution(result, input, index + 1);
                }
            }
        }
    }


}






