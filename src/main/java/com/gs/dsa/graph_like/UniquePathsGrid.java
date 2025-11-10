
package com.gs.dsa.graph_like;

/**
 * Count unique paths in m x n grid (right/down moves).
 * Edge cases: m<=0 or n<=0, large m/n (integer overflow discussion optional).
 */
public final class UniquePathsGrid {
    private UniquePathsGrid() {}
    /** TODO: Implement DP or combinatorics. */
    public static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        int totalMoves = m + n - 2;
        int downMoves = Math.min(m - 1, n - 1);

        int res = 1;
        for (int i = 1; i <= downMoves; i++) {
            res = res * (totalMoves - downMoves + i) / i;
        }

        return res;
    }
}
