package org.example.solutions;

import java.util.*;

public class Interval implements DefaultSolution {


    static class Range {
        Integer start;
        Integer end;
        Set<String> systems;

        public Range(int start, int end, Set<String> systems) {
            this.start = start;
            this.end = end;
            this.systems = systems;
        }

        @Override
        public String toString() {
            return "[" + start + "-" + end + "] " + systems;
        }
    }

    List<Range> calculateIntervals(Map<String, List<Integer>> systems) {
        TreeMap<Integer, Set<String>> versionMap = new TreeMap<>();
        for (Map.Entry<String, List<Integer>> entry : systems.entrySet()) {
            String system = entry.getKey();
            List<Integer> versions = entry.getValue();
            int start = versions.get(0);
            int end = versions.get(1);
            for (int i = start; i <= end; i++) {
                versionMap.computeIfAbsent(i, t -> new HashSet<>()).add(system);
            }
        }
        List<Range> result = new ArrayList<>();
        Integer prevVersion = null;
        Set<String> currentSystems = new HashSet<>();

        for (Map.Entry<Integer, Set<String>> entry : versionMap.entrySet()) {
            int version = entry.getKey();
            Set<String> systemsForVersion = entry.getValue();
            if (prevVersion != null && !systemsForVersion.equals(currentSystems)) {
                result.add(new Range(prevVersion, version - 1, new HashSet<>(currentSystems)));
                prevVersion = version;
                currentSystems = systemsForVersion;
            }
            if (prevVersion == null) {
                prevVersion = version;
                currentSystems = systemsForVersion;
            }
        }
        result.add(new Range(prevVersion, versionMap.lastKey(), new HashSet<>(currentSystems)));
        return result;
    }

    @Override
    public void runDefaultExample() {
        Map<String, List<Integer>> systems = new HashMap<>();
        systems.put("A1", List.of(0,5));
        systems.put("A2", List.of(3,5));
        systems.put("A3", List.of(6,8));
        System.out.println(calculateIntervals(systems));
    }
}
