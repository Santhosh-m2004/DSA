package Recursion;

import java.util.*;

public class subset2 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        subset(nums, 0, lst, ans);
        return lst;
    }

    public static void subset(int[] nums, int idx, List<List<Integer>> lst, List<Integer> ans) {
        lst.add(new ArrayList<>(ans));

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;

            ans.add(nums[i]);
            subset(nums, i + 1, lst, ans);
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }
}
