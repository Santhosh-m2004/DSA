package leetcode;

import java.util.*;

public class lt992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    public static int helper(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, count = 0;

        while (right < nums.length) {
            int num = nums[right];
            map.put(num, map.getOrDefault(num, 0) + 1);

            while (map.size() > k) {
                int n = nums[left];
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0) {
                    map.remove(n);
                }
                left++;
            }

            count += (right - left + 1);
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        lt992 sol = new lt992();
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(sol.subarraysWithKDistinct(nums, k));
    }
}

