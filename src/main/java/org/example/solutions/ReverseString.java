package org.example.solutions;

public class ReverseString implements DefaultSolution {

    public String reverse(String input) {
        if (input.length() <= 1) return input;

        char[] inputCharArray = input.toCharArray();
        int left = 0;
        int right = inputCharArray.length - 1;

        while (left < right) {
            char temp = inputCharArray[left];
            inputCharArray[left] = inputCharArray[right];
            inputCharArray[right] = temp;
            left++;
            right--;
        }

        return new String(inputCharArray);
    }

    @Override
    public void runDefaultExample() {
        System.out.println(reverse("MARS"));
    }
}
