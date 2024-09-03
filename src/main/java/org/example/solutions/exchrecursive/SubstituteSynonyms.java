package org.example.solutions.exchrecursive;

import org.example.solutions.DefaultSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SubstituteSynonyms implements DefaultSolution {

    private List<String> substituteSynonyms(String sentence, Map<String, List<String>> synonyms) {
        List<String> words = Arrays.asList(sentence.split(" "));
        List<List<String>> lists = generate(words, synonyms);

        List<String> finalSentences = new ArrayList<>();
        for (List<String> list : lists) {
            finalSentences.add(String.join(" ", list));
        }
        return finalSentences;
    }

    private List<List<String>> generate(List<String> words, Map<String, List<String>> synonyms) {
        if (words.size() == 0) return List.of(List.of());
        String word = words.get(0);
        List<List<String>> subLists = generate(words.subList(1, words.size()), synonyms);
        List<List<String>> results = new ArrayList<>();
        if (synonyms.containsKey(word)) {
            for (String substitute : synonyms.get(word)) {
                for (List<String> subList : subLists) {
                    List<String> result = new ArrayList<>();
                    result.add(substitute);
                    result.addAll(subList);

                    results.add(result);
                }
            }
        } else {
            for (List<String> subList : subLists) {
                List<String> result = new ArrayList<>();
                result.add(word);
                result.addAll(subList);

                results.add(result);
            }
        }
        return results;
    }


    @Override
    public void runDefaultExample() {
        String sentence = "I think its gonna be a long long time";
        Map<String, List<String>> synonyms = Map.of(
                "think", List.of("believe", "reckon"),
                "long", List.of("lengthy", "prolonged")
        );

        System.out.println(substituteSynonyms(sentence, synonyms));
        // [
        //   "I believe it's gonna be a lengthy lengthy time",
        //   "I believe it's gonna be a lengthy prolonged time",
        //   "I believe it's gonna be a prolonged lengthy time",
        //   "I believe it's gonna be a prolonged prolonged time",
        //   "I reckon it's gonna be a lengthy lengthy time",
        //   "I reckon it's gonna be a lengthy prolonged time",
        //   "I reckon it's gonna be a prolonged lengthy time",
        //   "I reckon it's gonna be a prolonged prolonged time"
        // ]
    }
}
