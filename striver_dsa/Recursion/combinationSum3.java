package Recursion;

import java.util.ArrayList;
import java.util.List;

public class combinationSum3 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] candidates={1,2,3,4,5,6,7,8,9};
        subset(candidates,k, n, 0, 0, lst, ans);
        return lst;
    }

    public static void subset(int[] candidates,int k, int target, int idx, int sum, List<List<Integer>> lst, List<Integer> ans) {
        if (sum == target && ans.size()==k) {
            lst.add(new ArrayList<>(ans));
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;

            if (sum + candidates[i] > target) break;

            ans.add(candidates[i]);
            subset(candidates,k, target, i + 1, sum + candidates[i], lst, ans);
            ans.remove(ans.size() - 1);
        }
    }
    public static void main(String[] args) {
        int k=3;
        int n=9;
        System.out.println(combinationSum3(k, n));
    }
}

