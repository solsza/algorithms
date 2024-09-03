package org.example.solutions.exchrecursive;

import org.example.solutions.DefaultSolution;

import java.util.ArrayList;
import java.util.List;

public class ParentheticalPossibilities implements DefaultSolution {

    private List<String> parentheticalPossibilities(String s) {
        if (s.isEmpty()) return List.of("");
        List<String> groupInfo = parseGroup(s);
        String group = groupInfo.get(0);
        String remainder = groupInfo.get(1);
        List<String> suffixes = parentheticalPossibilities(remainder);
        List<String> result = new ArrayList<>();
        for (char ch : group.toCharArray()) {
            for (String suffix : suffixes) {
                result.add(ch + suffix);
            }
        }
        return result;
    }

    private List<String> parseGroup(String s) {
        if (s.charAt(0) == '(') {
            int i = s.indexOf(')');
            return List.of(s.substring(1, i), s.substring(i + 1));
        }
        return List.of(String.valueOf(s.charAt(0)), s.substring(1));
    }

    @Override
    public void runDefaultExample() {
        System.out.println(parentheticalPossibilities("x(mn)yz"));
        // ->
        // [ "xmyz", "xnyz" ]
        System.out.println(parentheticalPossibilities("(etc)(blvd)(cat)")); // ->
        // [
        //  "ebc", "eba", "ebt", "elc", "ela",
        //  "elt", "evc", "eva", "evt", "edc",
        //  "eda", "edt", "tbc", "tba", "tbt",
        //  "tlc", "tla", "tlt", "tvc", "tva",
        //  "tvt", "tdc", "tda", "tdt", "cbc",
        //  "cba", "cbt", "clc", "cla", "clt",
        //  "cvc", "cva", "cvt", "cdc", "cda",
        //  "cdt"
        // ]
    }
}
