
package com.gs.dsa.arrays;

/**
 * Return the k-th largest element.
 * Preferred approaches: min-heap of size k (n log k) or quickselect (avg O(n)).
 */

import java.util.Collections;
import java.util.PriorityQueue;

/**
 *A Min Heap is a complete binary tree (every level except possibly the last is full) that satisfies
 * the heap property:
 * For every node i, its value ≤ its children’s values.
 *
 * Quick Select is based on the same idea as QuickSort, but instead of fully sorting the array,
 * it partially partitions until the k-th element is in its correct position.
 */
public final class KthLargestElement {

    private KthLargestElement() {}

    /**
     * Implement using heap or quickselect.
     */
    public static int kthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums) {
            minHeap.offer(num);
            if(minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }
}
