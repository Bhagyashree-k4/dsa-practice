
package com.gs.dsa.arrays;

/**
 * Search target in a rotated sorted array (may contain duplicates).
 * Expected: O(log n) average using binary search; degrade gracefully on duplicates.
 * Edge cases: empty, single-element, ambiguous boundaries (l==mid==r), pivot near ends, negatives.
 */
public final class SearchInRotatedSortedArray {
    private SearchInRotatedSortedArray() {}
    /** TODO: Implement rotated binary search with duplicate handling. */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // Handle duplicates
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
            // Left side sorted
           else if(nums[left] <= nums[mid]) {
               if(nums[left] <= target && nums[mid] >= target) {
                   right = mid - 1;
               } else {
                   left = mid + 1;
               }
            }
           //right side sorted
            else {
                if(nums[mid] <= target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
