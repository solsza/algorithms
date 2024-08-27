package org.example.solutions;

public class Uncompressed implements DefaultSolution {

    private String uncompressed(String s) {
        String numbers = "0123456789";
        StringBuilder result = new StringBuilder();
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            String character = String.valueOf(s.charAt(j));
            if(numbers.contains(character)) {
                j += 1;
            } else {
                int number = Integer.parseInt(s.substring(i, j));
                result.append(character.repeat(number));
                j += 1;
                i = j;
            }
        }
        return result.toString();
    }


    @Override
    public void runDefaultExample() {
        System.out.println(uncompressed("2c3a1t"));
        System.out.println(uncompressed("4s2b"));
        System.out.println(uncompressed("2p1o5p"));
        System.out.println(uncompressed("3n12e2z"));
        System.out.println(uncompressed("127y"));

    }
}
