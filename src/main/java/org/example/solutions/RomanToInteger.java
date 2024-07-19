package org.example.solutions;

public class RomanToInteger implements DefaultSolution {

    public int romanToInt(String s) {
        int result = 0;
        int currentValue = 0;
        int previousNumber = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I':
                    currentValue = 1;
                    break;
                case 'V':
                    currentValue = 5;
                    break;
                case 'X':
                    currentValue = 10;
                    break;
                case 'L':
                    currentValue = 50;
                    break;
                case 'C':
                    currentValue = 100;
                    break;
                case 'D':
                    currentValue = 500;
                    break;
                case 'M':
                    currentValue = 1000;
                    break;
            }
            if (currentValue < previousNumber) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            previousNumber = currentValue;
        }
        return result;
    }

    public void runDefaultExample() {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
