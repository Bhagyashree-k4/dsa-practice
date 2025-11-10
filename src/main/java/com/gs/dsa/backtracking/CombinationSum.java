
package com.gs.dsa.backtracking;

import java.util.*;

/**
 * Return all unique combinations summing to target; candidates may be reused.
 * Edge cases: empty candidates, target < smallest, duplicates handling via sort.
 */
public final class CombinationSum {
    private CombinationSum() {}
    /** TODO: Implement DFS/backtracking with pruning. */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;

        Arrays.sort(candidates); // handle duplicates & enable pruning
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int remain, int start,
                                  List<Integer> path, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            if (num > remain) break; // pruning
            path.add(num);
            backtrack(candidates, remain - num, i, path, result); // reuse same num
            path.remove(path.size() - 1); // backtrack
        }
        }
}
