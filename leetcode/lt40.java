package leetcode;

import java.util.*;

public class lt40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        recursion(0, candidates, 0, target, res, lst);
        return res;
    }

    public static void recursion(int idx, int[] candidates, int sum, int target, List<List<Integer>> res, List<Integer> lst) {
        if (sum == target) {
            res.add(new ArrayList<>(lst));
            return;
        }

        if (sum > target) return;

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue; // skip duplicates

            lst.add(candidates[i]);
            recursion(i + 1, candidates, sum + candidates[i], target, res, lst);
            lst.remove(lst.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }
}
