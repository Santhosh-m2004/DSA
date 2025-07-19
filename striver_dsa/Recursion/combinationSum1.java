package Recursion;

import java.util.*;

public class combinationSum1 {
    public static List<List<Integer>> comSum(int[] candidates,int target){
        List<List<Integer>> lst=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        subset(candidates, target, 0, 0, lst, ans);
        return lst;
    }

    public static void subset(int[] candidates,int target,int idx,int sum,List<List<Integer>> lst,List<Integer> ans){
        if(sum==target){
            lst.add(new ArrayList<>(ans));
            return;
        }
        if(idx==candidates.length || sum>target){
            return;
        }

        ans.add(candidates[idx]);
        subset(candidates, target, idx, sum+candidates[idx], lst, ans);
        ans.remove(ans.size()-1);
        subset(candidates, target, idx+1, sum, lst, ans);
    }

    public static void main(String[] args) {
        int[] candidates={2,3,6,7};
        int target=7;
        System.out.println(comSum(candidates,target));
    }
}
