package com.gs.dsa.dp;

/**
 * Use dynamic programming to decide for each skill whether to take it or skip it.
 * At each step, choose the maximum between skipping the current skill or taking it plus the best from two steps back.
 * This ensures you maximize total skill points without selecting adjacent skills.
 */

public class MaxNonAdjacentSkillPoint {
    public static void main(String[] args) {
        int[] skill_points = {10, 50, 20, 30};
        System.out.println(maxSkillPoints(skill_points)); // Output: 80
    }

    public static int maxSkillPoints(int[] skill_points) {
        int n = skill_points.length;
        if (n == 0) return 0;
        if (n == 1) return skill_points[0];

        int prev2 = skill_points[0];
        int prev1 = Math.max(skill_points[0], skill_points[1]);

        for (int i = 2; i < n; i++) {
            int curr = Math.max(prev1, prev2 + skill_points[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}

