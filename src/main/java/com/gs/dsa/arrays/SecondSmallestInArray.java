
package com.gs.dsa.arrays;

/**
 * Find second smallest distinct value in one pass.
 * Edge cases: duplicates, all equal, fewer than 2 distinct values.
 */
public final class SecondSmallestInArray {
    private SecondSmallestInArray() {}
    /** TODO: Implement single-pass tracking of min and second min. */
    public static int secondSmallest(int[] nums) {
        if(nums == null || nums.length < 2) {
            throw new IllegalArgumentException("To find second minimum array must have 2 elements");
        }

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int num : nums) {
            if(num < min1) {
                min2 = min1;
                min1 = num;
            } else if(num > min1 && num < min2) {
                min2 = num;
            }
        }
        return min2;
    }
}
