/*
Problem: Frog Jump (DP-3)

A frog is at stone 0 and wants to reach stone n-1.
Each stone has a height.
From stone i, the frog can jump to i+1 or i+2.
Cost of a jump = |height[i] - height[j]|.
Find minimum total cost to reach the last stone.
*/

import java.util.*;

public class dp3_FrogJump {

    public static int frogJump(int[] heights) {
        int n = heights.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return solve(n - 1, heights, memo);  // Start from last stone
    }

    private static int solve(int i, int[] heights, int[] memo) {

        if (i == 0) return 0; // No cost to stay on first stone

        if (memo[i] != -1) return memo[i]; // Use already computed value

        // Cost if frog comes from previous stone
        int oneJump = solve(i - 1, heights, memo)
                        + Math.abs(heights[i] - heights[i - 1]);

        int twoJump = Integer.MAX_VALUE;

        // Cost if frog comes from two stones back
        if (i > 1)
            twoJump = solve(i - 2, heights, memo)
                        + Math.abs(heights[i] - heights[i - 2]);

        // Choose minimum energy path
        memo[i] = Math.min(oneJump, twoJump);
        return memo[i];
    }

    public static void main(String[] args) {
        int[] h1 = {10, 20, 30, 10};
        int[] h2 = {10, 50, 10};

        System.out.println(frogJump(h1)); // 20
        System.out.println(frogJump(h2)); // 0
    }
}

