
package com.gs.dsa.graph_like;

/**
 * From a start index, detect cycle length with consistent movement direction.
 * Edge cases: self-loops invalid, mixed directions, out-of-bounds.
 */
public final class CircularArrayLoopFromStart {
    private CircularArrayLoopFromStart() {}
    /** Implement Floyd cycle detection with direction checks. */
    public static int loopLength(int[] nums, int startIndex) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        if (startIndex < 0 || startIndex >= n) return -1;

        boolean forward = nums[startIndex] > 0; // direction consistency
        int slow = startIndex, fast = startIndex;

        while (true) {
            slow = nextIndex(nums, forward, slow);
            fast = nextIndex(nums, forward, nextIndex(nums, forward, fast));

            if (slow == -1 || fast == -1) return -1; // invalid move
            if (slow == fast) break; // cycle found
        }

        // Compute cycle length
        int cycleLen = 1;
        int ptr = nextIndex(nums, forward, slow);
        while (ptr != slow && ptr != -1) {
            cycleLen++;
            ptr = nextIndex(nums, forward, ptr);
        }

        // Invalid cycle (if broken mid-way)
        if (ptr == -1 || cycleLen == 1) return -1;
        return cycleLen;
    }

    /** Returns next index if valid, else -1 */
    private static int nextIndex(int[] nums, boolean forward, int i) {
        int n = nums.length;
        boolean dir = nums[i] > 0;
        if (dir != forward) return -1; // mixed direction not allowed

        int next = ((i + nums[i]) % n + n) % n; // handle wrap-around safely
        if (next == i) return -1; // self-loop
        return next;
    }
}
