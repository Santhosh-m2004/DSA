package DP;
// Description:
// Frog Jump Problem (Striver DP Series):
// A frog is at index 0 and wants to reach the last index of the heights array.
// The frog can jump either 1 step or 2 steps at a time.
// The cost of jumping from index i to j is |heights[i] - heights[j]|.
// Goal: Return the minimum total cost to reach the last index.
//
// Input Example: [10, 20, 30, 10]
// Output: 20

import java.util.*;

public class FrogJump{

    private static int frogJumpMemoHelper(int idx, int[] heights, int[] dp) {
        if (idx == 0) return 0;
        if (dp[idx] != -1) return dp[idx];

        int oneStep = frogJumpMemoHelper(idx - 1, heights, dp) + Math.abs(heights[idx] - heights[idx - 1]);
        int twoStep = Integer.MAX_VALUE;

        if (idx > 1)
            twoStep = frogJumpMemoHelper(idx - 2, heights, dp) + Math.abs(heights[idx] - heights[idx - 2]);

        dp[idx] = Math.min(oneStep, twoStep);
        return dp[idx];
    }

    public static int frogJumpMemo(int[] heights) {
        int[] dp = new int[heights.length];
        Arrays.fill(dp, -1);
        return frogJumpMemoHelper(heights.length - 1, heights, dp);
    }

    public static int frogJumpTabu(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int oneStep = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int twoStep = Integer.MAX_VALUE;

            if (i > 1)
                twoStep = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);

            dp[i] = Math.min(oneStep, twoStep);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] heights1 = {10, 20, 30, 10};
        int[] heights2 = {30, 10, 60, 10, 60, 50};

        System.out.println("Memo (Test1): " + frogJumpMemo(heights1));
        System.out.println("Memo (Test2): " + frogJumpMemo(heights2));

        System.out.println("Tabu (Test1): " + frogJumpTabu(heights1));
        System.out.println("Tabu (Test2): " + frogJumpTabu(heights2));
    }
}

