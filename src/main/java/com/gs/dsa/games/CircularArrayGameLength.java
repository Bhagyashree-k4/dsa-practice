
package com.gs.dsa.games;

/**
 * Given array with next-index pointers, return cycle length.
 * Edge cases: invalid 0-pointer, multiple cycles, single-node cycle.
 */
public final class CircularArrayGameLength {
    private CircularArrayGameLength() {
    }

    /**
     * TODO: Implement Floyd cycle detection tailored to index mapping.
     */
    public static Integer cycleLength(int[] arr) {
        int slow = 0, fast = 0;

        while (true) {
            // move slow
            if (slow < 0 || slow >= arr.length) return null;
            slow = arr[slow];

            // move fast once
            if (fast < 0 || fast >= arr.length) return null;
            fast = arr[fast];

            // move fast twice
            if (fast < 0 || fast >= arr.length) return null;
            fast = arr[fast];

            // names meet → cycle found
            if (slow == fast) break;
        }

        // measure length
        int count = 1;
        fast = arr[fast];
        while (slow != fast) {
            fast = arr[fast];
            count++;
        }

        return count;
    }

}

