package leetcode;

/**
 * Problem: Jump Game II (LeetCode 45)
 *
 * You are given an integer array nums where nums[i] represents the
 * maximum number of steps you can jump forward from index i.
 *
 * You start at index 0 and want to reach the last index using
 * the **minimum number of jumps**.
 *
 * Approach Used (Your Recursive Brute Force Method):
 * - From each index, try all possible jump lengths (1 to nums[idx]).
 * - Recursively explore all future paths.
 * - Return the minimum number of jumps among all paths.
 *
 * Note: This approach is correct but very slow for large inputs.
 *
 * Time Complexity:  O(n^n)  (exponential, because all paths are explored)
 * Space Complexity: O(n)    (recursion stack depth)
 */

import java.util.*;

public class lt45 {

    public static int jump(int[] nums) {
        return recursion(nums, 0, 0);
    }

    public static int recursion(int[] nums, int idx, int jump) {
        if (idx >= nums.length - 1) {
            return jump;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= nums[idx]; i++) {
            min = Math.min(min, recursion(nums, idx + i, jump + 1));
        }

        return min;
    }

    public static void main(String[] args) {

        int[] numsTrue  = {2, 3, 1, 1, 4}; // Expected: 2
        int[] numsFalse = {1, 1, 1, 1};    // Expected: 3 

        System.out.println("Test Case 1 -> " + jump(numsTrue));
        System.out.println("Test Case 2 -> " + jump(numsFalse));
    }
}
