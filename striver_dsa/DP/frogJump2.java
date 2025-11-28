package DP;

// Description:
// Frog Jump II - Tabulation DP (Striver Approach)
// The frog starts at index 0 and must reach the last index of the heights array.
// From index i, it can jump to any index j where (1 <= j - i <= k).
// Jump cost = |heights[i] - heights[j]|
// Return the minimum total energy required.
//
// Example:
// Input: heights = [10, 30, 40, 50, 20], k = 3
// Output: 30

import java.util.*;

public class FrogJump2 {

    public static int frogJumpTabu(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int jump = 1; jump <= k; jump++) {
                if (i - jump >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - jump] 
                        + Math.abs(heights[i] - heights[i - jump]));
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] heights1 = {10, 30, 40, 50, 20};
        int[] heights2 = {10, 20, 10};
        int k1 = 3;
        int k2 = 2;

        System.out.println("Tabu (Test1): " + frogJumpTabu(heights1, k1));
        System.out.println("Tabu (Test2): " + frogJumpTabu(heights2, k2));
    }
}
