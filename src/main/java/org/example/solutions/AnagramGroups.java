package org.example.solutions;

import java.util.*;

public class AnagramGroups implements DefaultSolution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(s);
        }
        return new ArrayList<>(result.values());
    }

    @Override
    public void runDefaultExample() {
        String[] strs = new String[]{"act","pots","tops","cat","stop","hat"};
        System.out.println(groupAnagrams(strs));
    }
}
