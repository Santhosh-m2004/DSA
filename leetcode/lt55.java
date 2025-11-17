package leetcode;


/**
 * Problem: Jump Game (LeetCode 55)
 *
 * You are given an integer array nums where nums[i] represents
 * the maximum jump length from index i.
 *
 * Starting at index 0, determine whether you can reach the last index.
 *
 * Greedy Approach:
 * - Maintain the farthest reachable index (maxReach).
 * - Iterate through the array:
 *   • If current index > maxReach -> stuck -> return false
 *   • Update maxReach = max(maxReach, i + nums[i])
 *
 * Return:
 *   true  -> if we can reach the final index
 *   false -> if we get stuck before reaching the last index
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 */

import java.util.*;

public class lt55 {

    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {

        int[] numsTrue  = {2, 3, 1, 1, 4};    // Expected: true
        int[] numsFalse = {3, 2, 1, 0, 4};    // Expected: false

        System.out.println("Test Case 1 (True Expected)  -> " + canJump(numsTrue));
        System.out.println("Test Case 2 (False Expected) -> " + canJump(numsFalse));
    }
}
