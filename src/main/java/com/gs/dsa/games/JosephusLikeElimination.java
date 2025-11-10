
package com.gs.dsa.games;

/**
 * Josephus-style elimination: return elected student number (1..n).
 * Expected: O(n) iterative formula or linked simulation; discuss space trade-offs.
 */
public final class JosephusLikeElimination {
    private JosephusLikeElimination() {}
    /** TODO: Implement iterative formula (0-index then +1). */
    public static int elect(int n, int k) {
        if (n <= 0 || k <= 0) return -1;

        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + k) % i;
        }
        return result + 1;
    }
}
