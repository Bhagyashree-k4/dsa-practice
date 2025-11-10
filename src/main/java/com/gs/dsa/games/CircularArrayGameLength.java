
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
    public static int cycleLength(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int n = nums.length;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            int slow = i, fast = i;
            while (true) {
                slow = nextIndex(nums, slow);
                fast = nextIndex(nums, nextIndex(nums, fast));

                if (slow == -1 || fast == -1) break;
                if (slow == fast) {
                    return countCycleLength(nums, slow);
                }
            }
            visited[i] = true;
        }
        return -1;
    }

    private static int nextIndex(int[] nums, int idx) {
        if (idx < 0 || idx >= nums.length) return -1;
        int next = nums[idx];
        if (next == 0) return -1;
        int mapped = (next - 1);
        if (mapped < 0 || mapped >= nums.length) return -1;
        return mapped;
    }

    private static int countCycleLength(int[] nums, int start) {
        int length = 1;
        int curr = nextIndex(nums, start);
        while (curr != start && curr != -1) {
            length++;
            curr = nextIndex(nums, curr);
        }
        return length;
    }
}
