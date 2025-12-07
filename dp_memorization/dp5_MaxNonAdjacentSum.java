/*
Problem: Maximum Sum of Non-Adjacent Elements (DP-5)

You are given an array of integers.
You must pick elements such that no two selected elements are adjacent.
Return the maximum possible sum.
*/

import java.util.*;

public class dp5_MaxNonAdjacentSum {

    public static int maxSum(int[] arr) {
        int n = arr.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return solve(n - 1, arr, memo);
    }

    private static int solve(int i, int[] arr, int[] memo) {

        if (i < 0) return 0;      // No elements left
        if (i == 0) return arr[0]; // Only one element choice

        if (memo[i] != -1) return memo[i]; // Use cached result

        // Pick current element and skip previous
        int pick = arr[i] + solve(i - 2, arr, memo);

        // Skip current element
        int notPick = solve(i - 1, arr, memo);

        // Take maximum of pick / skip
        memo[i] = Math.max(pick, notPick);
        return memo[i];
    }

    public static void main(String[] args) {
        int[] a1 = {2, 1, 4, 9};    // answer = 11
        int[] a2 = {4, 1, 1, 4, 2}; // answer = 8

        System.out.println(maxSum(a1));
        System.out.println(maxSum(a2));
    }
}
