package org.example.solutions;

public class AddBinary implements DefaultSolution {

    public String addBinary(String a, String b) {
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        int i = a.toCharArray().length - 1;
        int j = b.toCharArray().length - 1;
        int shift = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || shift == 1) {
            if (i >= 0) {
                shift += aArray[i--] - '0';
            }
            if (j >= 0) {
                shift += bArray[j--] - '0';
            }
            sb.append(shift % 2);
            shift = shift / 2;
        }
        return sb.reverse().toString();
    }


    public void runDefaultExample() {
        System.out.println(addBinary("1010", "1011"));
    }
}
