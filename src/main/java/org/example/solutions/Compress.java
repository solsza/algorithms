package org.example.solutions;

public class Compress implements DefaultSolution {

    private String compress(String s) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        char current = s.charAt(0);
        for (char letter : s.toCharArray()) {
            if (letter == current) {
                i += 1;
            } else {
                update(i,current,result);
                current = letter;
                i = 1;
            }
        }
        return update(i, current, result).toString();
    }

    private StringBuilder update(int i, char current, StringBuilder result) {
        if(i == 1) {
            result.append(current);
        }
        else {
            result.append(i).append(current);
        }
        return result;
    }

    @Override
    public void runDefaultExample() {
        System.out.println(compress("ccaaatsss"));
        System.out.println(compress("ssssbbz"));
        System.out.println(compress("ppoppppp"));
        System.out.println(compress("nnneeeeeeeeeeeezz"));
        System.out.println(compress("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy"));
    }
}

