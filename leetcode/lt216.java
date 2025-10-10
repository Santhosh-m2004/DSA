package leetcode;

import java.util.*;

public class lt216 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        recursion(0, candidates, 0, n, res, lst, k);
        return res;
    }

    public static void recursion(int idx, int[] candidates, int sum, int target, List<List<Integer>> res, List<Integer> lst, int k) {
        if (sum == target && lst.size() == k) {
            res.add(new ArrayList<>(lst));
            return;
        }

        if (sum > target || lst.size() > k || idx >= candidates.length) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            lst.add(candidates[i]);
            recursion(i + 1, candidates, sum + candidates[i], target, res, lst, k);
            lst.remove(lst.size() - 1);
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        System.out.println(combinationSum3(k, n));
    }
}
