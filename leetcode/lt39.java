package leetcode;

import java.util.*;

public class lt39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        recursion(0, candidates, target, res, lst);
        return res;
    }

    public static void recursion(int idx, int[] candidates, int target, List<List<Integer>> res, List<Integer> lst) {
        if (idx == candidates.length) {
            if (target == 0) {
                res.add(new ArrayList<>(lst));
            }
            return;
        }

        if (candidates[idx] <= target) {
            lst.add(candidates[idx]);
            recursion(idx, candidates, target - candidates[idx], res, lst);
            lst.remove(lst.size() - 1);
        }

        recursion(idx + 1, candidates, target, res, lst);
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }
}
