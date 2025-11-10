
package com.gs.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Variants: first valid pair (hashmap), smallest indices (lexicographic), largest indices.
 * Expected: O(n) for first; others can pre-index positions.
 */
public final class TwoSumVariants {
    private TwoSumVariants() {
    }

    /**
     * TODO: First valid pair using hashmap.
     */
    public static int[] twoSumFirst(int[] nums, int target) {

        Map<Integer, Integer> complement = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (complement.containsKey(target - nums[i])) {
                return new int[]{complement.get(target - nums[i]), i};
            } else {
                complement.put(nums[i], i);
            }
        }

        return new int[]{-2, -2};
    }

    /**
     * TODO: Lexicographically smallest index pair.
     */
    public static int[] twoSumSmallestIndices(int[] nums, int target) {
        Map<Integer, Integer> complement = new HashMap<>();
        int idx1 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (complement.containsKey(target - nums[i])) {
                if (idx1 > i) idx1 = i;
                if (idx1 > complement.get(target - nums[i])) {
                    idx1 = complement.get(target - nums[i]);
                }
            }
            complement.put(nums[i], i);
        }

        return new int[]{idx1, complement.get(target - nums[idx1])};
    }


    /**
     * TODO: Lexicographically largest index pair.
     */
    public static int[] twoSumLargestIndices(int[] nums, int target) {
        Map<Integer, Integer> pair = new HashMap<>();
        int idx1 = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            if(pair.containsKey(target - nums[i])) {
                if(idx1 < i) idx1 = i;
                if(idx1 < pair.get(target - nums[i])) {
                    idx1 = pair.get(target - nums[i]);
                }
            }
            pair.put(nums[i], i);
        }
        return new int[]{pair.get(target - nums[idx1]), idx1};
    }
}
