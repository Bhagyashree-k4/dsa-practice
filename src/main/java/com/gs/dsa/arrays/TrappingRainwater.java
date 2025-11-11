
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

        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }

    public static int trapWithGaps(int[] height) {
        if (height == null || height.length == 0) return 0;

        int n = height.length;
        int totalLen = 2 * n - 1; // including gaps
        int left = 0, right = totalLen - 1;
        int leftMax = 0, rightMax = 0;
        int total = 0;

        while (left <= right) {
            int leftH = (left % 2 == 0) ? height[left / 2] : 0;  // gap height = 0
            int rightH = (right % 2 == 0) ? height[right / 2] : 0;

            if (leftH <= rightH) {
                leftMax = Math.max(leftMax, leftH);
                total += Math.max(0, leftMax - leftH);
                left++;
            } else {
                rightMax = Math.max(rightMax, rightH);
                total += Math.max(0, rightMax - rightH);
                right--;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] h = {3, 1, 2};
        System.out.println(trap(h)); // Output: 9 (same as expanded visualization)
    }
}
