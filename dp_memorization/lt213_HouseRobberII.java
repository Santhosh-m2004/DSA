/*
Problem: House Robber II

You are given an array where each value represents money in a house.
Houses are arranged in a circle.
You cannot rob two adjacent houses.
Return the maximum money you can rob.
*/

import java.util.*;

public class lt213_HouseRobberII {

    public int rob(int[] nums) {

        if (nums.length == 1) return nums[0];

        // Case 1: Rob houses from index 0 to n-2
        int case1 = robRange(nums, 0, nums.length - 2);

        // Case 2: Rob houses from index 1 to n-1
        int case2 = robRange(nums, 1, nums.length - 1);

        return Math.max(case1, case2);
    }

    private int robRange(int[] nums, int start, int end) {

        int n = end - start + 1;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);

        return solve(end, nums, start, memo);
    }

    private int solve(int i, int[] nums, int start, int[] memo) {

        if (i < start) return 0;

        if (memo[i - start] != -1) return memo[i - start];

        // Rob this house and skip previous
        int pick = nums[i] + solve(i - 2, nums, start, memo);

        // Skip this house
        int skip = solve(i - 1, nums, start, memo);

        memo[i - start] = Math.max(pick, skip);
        return memo[i - start];
    }

    public static void main(String[] args) {
        lt213_HouseRobberII s = new lt213_HouseRobberII();

        int[] a1 = {2, 3, 2};    // 3
        int[] a2 = {1, 2, 3, 1}; // 4

        System.out.println(s.rob(a1));
        System.out.println(s.rob(a2));
    }
}
