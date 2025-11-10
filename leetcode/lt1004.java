package leetcode;

import java.util.*;

public class lt1004 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 1, 1, 0, 1};
        int k = 2;

        lt1004 solution = new lt1004();
        int result = solution.longestOnes(nums, k);

        System.out.println("Longest subarray with at most " + k + " zero flips: " + result);
    }

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        int max = 0;

        while (right < nums.length) {
            if (nums[right] == 0) zeroCount++;
            right++;

            while (zeroCount > k) {
                if (nums[left] == 0) zeroCount--;
                left++;
            }

            max = Math.max(max, right - left);
        }

        return max;
    }
}
