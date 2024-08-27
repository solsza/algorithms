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

    public String reverse2(String input) {
        char[] reverseString = new char[input.length()];
        return reverseRecursive(reverseString, input, 0);
    }

    private String reverseRecursive(char[] reverseString, String input, int pointer) {
        if(pointer == input.length()) {
            return String.valueOf(reverseString);
        }
        reverseString[(input.length() -1) - pointer] = input.charAt(pointer);
        return reverseRecursive(reverseString, input, pointer + 1);
    }

    @Override
    public void runDefaultExample() {
        System.out.println(reverse("MARS"));

        System.out.println("Reverse option 2");
        System.out.println(reverse2("hello"));
        System.out.println(reverse2("abcdefg"));
        System.out.println(reverse2("stopwatch"));
        System.out.println(reverse2(""));
    }
}
