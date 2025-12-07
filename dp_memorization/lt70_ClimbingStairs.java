// package leetcode;

// LeetCode 70 - Climbing Stairs
// Memoization (Top-Down DP) solution
// You can run this directly in VS Code.

import java.util.*;

public class lt70_ClimbingStairs {

    public int climbStairs(int n) {
        // memo[i] will store: number of ways to reach step i
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1); // -1 means "not computed yet"
        return ways(n, memo);
    }

    // Helper: returns number of ways to reach step 'i'
    private int ways(int i, int[] memo) {
        if (i == 0) return 1; // 1 way to stay at ground
        if (i < 0) return 0;  // no way if we go below 0

        // If already computed, reuse it
        if (memo[i] != -1) return memo[i];

        // Recurrence: from step i, we can come from i-1 or i-2
        int count = ways(i - 1, memo) + ways(i - 2, memo);

        memo[i] = count; // store result in memo
        return count;
    }

    public static void main(String[] args) {
        lt70_ClimbingStairs solver = new lt70_ClimbingStairs();

        int n1 = 2; // Expected: 2 (1+1, 2)
        int n2 = 5; // Expected: 8

        System.out.println("n = " + n1 + " -> " + solver.climbStairs(n1));
        System.out.println("n = " + n2 + " -> " + solver.climbStairs(n2));
    }
}
