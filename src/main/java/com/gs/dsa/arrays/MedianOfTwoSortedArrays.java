
package com.gs.dsa.arrays;

/**
 * Use binary search on the smaller array to partition both arrays such that left parts
 * contain half of the elements. Check if all left elements are ≤ right elements.
 * if not, adjust the partition. Once the correct partition is found,
 * compute the median from the border elements in O(log min(n, m)) time.
 */
public final class MedianOfTwoSortedArrays {
    private MedianOfTwoSortedArrays() {
    }

    public static double findMedianSortedArrays(int[] a, int[] b) {


        if (a.length > b.length) {
            return findMedianSortedArrays(b, a);
        }

        int len1 = a.length, len2 = b.length;
        int low = 0, high = len1;

        while (low <= high) {

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

    public double findMedianSortedArraysUsingMerge(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int t = l1 + l2;
        int count = 0;
        int ind2 = t / 2;
        int ind1 = ind2 - 1;
        int ele1 = 0, ele2 = 0;
        int i = 0, j = 0;

        while (i < l1 && j < l2) {
            if (nums1[i] <= nums2[j]) {
                if (count == ind1) ele1 = nums1[i];
                if (count == ind2) {
                    ele2 = nums1[i];
                    break;
                }
                i++;
            } else {
                if (count == ind1) ele1 = nums2[j];
                if (count == ind2) {
                    ele2 = nums2[j];
                    break;
                }
                j++;
            }
            count++;
        }

        while (i < l1 && count <= ind2) {
            if (count == ind1) ele1 = nums1[i];
            if (count == ind2) {
                ele2 = nums1[i];
                break;
            }
            i++;
            count++;
        }

        while (j < l2 && count <= ind2) {
            if (count == ind1) ele1 = nums2[j];
            if (count == ind2) {
                ele2 = nums2[j];
                break;
            }
            j++;
            count++;
        }

        if (t % 2 == 0)
            return (ele1 + ele2) / 2.0;
        else
            return ele2;
    }
}
