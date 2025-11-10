
package com.gs.dsa.arrays;

/**
 * Compute trapped rainwater using two-pointer approach.
 * Expected: O(n) time, O(1) space. Edge cases: monotonic arrays, plateaus, large values.
 */
public final class TrappingRainwater {
    private TrappingRainwater() {
    }

    /**
     * Implement two-pointer accumulation.
     */
    public static int trap(int[] height) {
       int left = 0, leftMax = 0, rightMax = 0, water = 0;
       int right = height.length - 1;

       while(left < right) {
           if(height[left] <= height[right]) {
               if(height[left] > leftMax) {
                   leftMax = height[left];
               } else {
                   water += leftMax - height[left];
               }
               left++;
           } else {
               if(height[right] > rightMax) {
                   rightMax = height[right];
               } else {
                   water += rightMax - height[right];
               }
               right--;
           }
       }

       return water;
    }
}
