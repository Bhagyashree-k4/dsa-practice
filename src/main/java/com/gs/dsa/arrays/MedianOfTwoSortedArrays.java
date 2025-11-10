
package com.gs.dsa.arrays;

/**
 * Find the median of two sorted arrays without fully merging them.
 * Expected: ~O(log (m+n)) using partition-based binary search.
 * Edge cases: empty one array, skewed sizes, duplicates, negatives.
 */
public final class MedianOfTwoSortedArrays {
    private MedianOfTwoSortedArrays() {}
    /** TODO: Implement optimal partition-based median. */
    public static double findMedianSortedArrays(int[] a, int[] b) {


        if(a.length > b.length){
            return findMedianSortedArrays(b,a);
        }

        int len1 = a.length, len2 = b.length;
        int low = 0, high = len1;

        while(low<=high) {

            int mid1 = low + ((high - low) / 2);
            int mid2 = ((len1 + len2 + 1) / 2) - mid1;

            int left1 = mid1 == 0 ? Integer.MIN_VALUE : a[mid1 - 1];
            int left2 = mid2 == 0 ? Integer.MIN_VALUE : b[mid2 - 1];
            int right1 = mid1 == len1 ? Integer.MAX_VALUE : a[mid1];
            int right2 = mid2 == len2 ? Integer.MAX_VALUE : b[mid2];

            if (left1 <= right2 && left2 <= right1) {
                if ((len1 + len2) % 2 == 0) {
                    return (double) (Math.max(left1, left2) + Math.min(right1, right2)) / 2;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return Double.NaN;

    }
}
