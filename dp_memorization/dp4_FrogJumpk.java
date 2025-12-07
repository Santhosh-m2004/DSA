/*
Problem: Frog Jump with K Distances (DP-4)

A frog is at stone 0 and wants to reach stone n-1.
Each stone has a height given in array heights[].
From stone i, the frog can jump to any stone from i+1 to i+k.
Cost of a jump = |heights[i] - heights[j]|.
Find the minimum cost to reach the last stone.
*/

import java.util.*;

public class dp4_FrogJumpk{

    public static int frogJump(int[] heights, int k) {
        int n = heights.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return solve(n - 1, heights, k, memo);
    }

    private static int solve(int i, int[] heights, int k, int[] memo) {

        if (i == 0) return 0; // No cost at first stone

        if (memo[i] != -1) return memo[i]; // Use cached value

        int minCost = Integer.MAX_VALUE;

        // Try all jumps from 1 to k
        for (int j = 1; j <= k; j++) {

            if (i - j >= 0) {
                int jumpCost = solve(i - j, heights, k, memo)
                                + Math.abs(heights[i] - heights[i - j]);

                minCost = Math.min(minCost, jumpCost); // Choose minimum
            }
        }

        memo[i] = minCost;
        return memo[i];
    }

    public static void main(String[] args) {
        int[] h1 = {10, 30, 40, 50, 20};
        int k1 = 3;    // answer = 30

        int[] h2 = {40, 10, 20, 70, 80, 10};
        int k2 = 4;    // answer = 30

        System.out.println(frogJump(h1, k1));
        System.out.println(frogJump(h2, k2));
    }
}
