package org.example.solutions;

public class Palindrome implements DefaultSolution {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }

        char[] numberAsText = String.valueOf(x).toCharArray();
        int start = 0;
        int end = numberAsText.length - 1;
        int middle = (numberAsText.length - 1) / 2 + 1;

        while (start <= middle && end >= middle) {
            if (numberAsText[start] != numberAsText[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean isPalindromeWithoutString(int x) {

/**        it can be use to reduce number of iterations
 int numberOfDigits = (int) Math.log10(x)  + 1;**/

        if (x < 0) {
            return false;
        }
        int tmpNumber = x;
        int reverseNumber = 0;
        while (tmpNumber > 0) {
            int digit = tmpNumber % 10;
            reverseNumber = reverseNumber * 10 + digit;
            tmpNumber = tmpNumber / 10;

        }
        return reverseNumber == x;
    }

    public void runDefaultExample() {
        System.out.println(isPalindrome(1234821));
    }

}
