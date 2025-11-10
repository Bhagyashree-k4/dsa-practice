
package com.gs.dsa.students;

import java.util.*;

/**
 * Compute best average per student from [name, mark] pairs.
 * Edge cases: invalid/negative marks, missing rows, zero-count division.
 */
public final class BestAveragePerStudent {
    private BestAveragePerStudent() {}
    /** TODO: Aggregate sum/count per name and compute averages. */
    public static Map<String, Double> bestAverages(String[][] nameMarks) {
        Map<String, Integer> sumMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Double> result = new HashMap<>();

        if (nameMarks == null || nameMarks.length == 0)
            return result;

        for (String[] pair : nameMarks) {
            if (pair == null || pair.length != 2) continue;

            String name = pair[0];
            String markStr = pair[1];
            if (name == null || name.isBlank() || markStr == null) continue;

            try {
                int mark = Integer.parseInt(markStr.trim());
                if (mark < 0) continue;
                sumMap.put(name, sumMap.getOrDefault(name, 0) + mark);
                countMap.put(name, countMap.getOrDefault(name, 0) + 1);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }

        for (String name : sumMap.keySet()) {
            int count = countMap.getOrDefault(name, 0);
            if (count > 0) {
                double avg = sumMap.get(name) / (double) count;
                result.put(name, avg);
            }
        }

        return result;
    }
}
