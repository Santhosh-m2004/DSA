package DP;

import java.util.*;

/*
Frog Jump with K Steps:
The frog can jump up to 'k' steps at a time.
Each jump from i to j costs abs(height[i] - height[j]).
Find the minimum total cost to reach the last stair.
*/

public class frogJump2 {

    static int res(int[] height, int k) {
        int n = height.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        // Base case: no energy needed to be on the first stair
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;

            // Try all jumps from 1 to k steps behind
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    // Jump from i-j to i
                    int cost = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    minSteps = Math.min(minSteps, cost);
                }
            }
            dp[i] = minSteps;
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int height[] = {30, 10, 60, 10, 60, 50};
        int k = 2;
        System.out.println("Minimum energy with k steps: " + res(height, k));
    }
}
