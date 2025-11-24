package DP;

// Description:
// Frog Jump II - Dynamic Programming (Striver Approach)
// The frog starts at index 0 and must reach the last index of the heights array.
// The frog can jump up to k steps from any index.
// The cost of a jump from i to j is: |heights[i] - heights[j]|
// Return the minimum total cost to reach the last index.
//
// Example:
// Input: heights = [10, 30, 40, 50, 20], k = 3
// Output: 30

import java.util.*;

public class FrogJump2 {

    private static int helper(int idx, int[] heights, int k, int[] dp) {
        if (idx == 0) return 0;
        if (dp[idx] != -1) return dp[idx];

        int minCost = Integer.MAX_VALUE;

        for (int jump = 1; jump <= k; jump++) {
            if (idx - jump >= 0) {
                int cost = helper(idx - jump, heights, k, dp) 
                           + Math.abs(heights[idx] - heights[idx - jump]);
                minCost = Math.min(minCost, cost);
            }
        }

        dp[idx] = minCost;
        return dp[idx];
    }

    public static int frogJumpMemo(int[] heights, int k) {
        int[] dp = new int[heights.length];
        Arrays.fill(dp, -1);
        return helper(heights.length - 1, heights, k, dp);
    }

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

        System.out.println("Memo (Test1): " + frogJumpMemo(heights1, k1));
        System.out.println("Memo (Test2): " + frogJumpMemo(heights2, k2));

        System.out.println("Tabu (Test1): " + frogJumpTabu(heights1, k1));
        System.out.println("Tabu (Test2): " + frogJumpTabu(heights2, k2));
    }
}
