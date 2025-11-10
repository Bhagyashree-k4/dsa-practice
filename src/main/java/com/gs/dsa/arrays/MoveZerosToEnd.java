
package com.gs.dsa.arrays;

/**
 * Move zeros to the end in-place while preserving order of non-zeros.
 * Expected: O(n) time, O(1) space.
 */
public final class MoveZerosToEnd {
    private MoveZerosToEnd() {}
    /** TODO: Implement stable compaction. */
    public static void moveZeros(int[] nums) {
        int pos = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                swap(nums, i , pos);
                pos++;
            }
        }
    }

    private static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
