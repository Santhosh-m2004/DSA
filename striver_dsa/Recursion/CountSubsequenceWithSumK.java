package Recursion;

import java.util.*;

public class CountSubsequenceWithSumK {

    public static List<List<Integer>> subsequence(int[] nums, int k) {
        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int count = recursion(0, nums, subset, lst, 0, k);
        System.out.println("Count: " + count);
        return lst;
    }

    public static int recursion(int idx, int[] nums, List<Integer> subset, List<List<Integer>> lst, int sum, int k) {
        if (idx == nums.length) {
            if (sum == k) {
                lst.add(new ArrayList<>(subset));
                return 1; 
            }
            return 0;
        }

        subset.add(nums[idx]);
        int left = recursion(idx + 1, nums, subset, lst, sum + nums[idx], k);

        subset.remove(subset.size() - 1);
        int right = recursion(idx + 1, nums, subset, lst, sum, k);

        return left + right; 
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int k = 2;
        List<List<Integer>> result = subsequence(nums, k);
        System.out.println("Subsequences with sum " + k + ": " + result);
    }
}

