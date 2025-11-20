
package com.gs.dsa.graph_like;

/**
 * From a start index, detect cycle length with consistent movement direction.
 * Edge cases: self-loops invalid, mixed directions, out-of-bounds.
 */
public final class CircularArrayLoopFromStart {
    public static int circularArrayLoop(int[] nums, int startIndex) {
        int n = nums.length;

        int slow = startIndex, fast = startIndex;
        boolean forward = nums[startIndex] > 0;

        // ---------- Cycle detection ----------
        while (true) {
            slow = nextIndex(nums, forward, slow);
            if (slow == -1) break;

            fast = nextIndex(nums, forward, fast);
            if (fast == -1) break;

            fast = nextIndex(nums, forward, fast);
            if (fast == -1) break;

            if (slow == fast) {
                break;  // meeting point found → go count cycle
            }
        }

        // Invalid or no cycle
        if (slow == -1 || fast == -1 || slow != fast) {
            return 0;
        }

        // ---------- Count cycle length ----------
        int count = 1;
        int p = nextIndex(nums, forward, slow);
        while (p != slow) {
            count++;
            p = nextIndex(nums, forward, p);
        }
        return count;
    }

    private static int nextIndex(int[] nums, boolean forward, int idx) {
        boolean dir = nums[idx] > 0;
        if (dir != forward) return -1;

        int n = nums.length;
        int next = ((idx + nums[idx]) % n + n) % n;

        if (next == idx) return -1; // no 1-element loops
        return next;
    }

}
