package Recursion;

import java.util.*;

public class only1subsequencewithSumk {

    public static List<List<Integer>> subsequence(int[] nums,int k){
        List<List<Integer>> lst=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        recursion(0,nums,subset,lst,0,k);
        return lst;
    }
    public static boolean recursion(int idx,int[] nums,List<Integer> subset,List<List<Integer>> lst,int sum,int k){
        if(idx==nums.length){
            if(sum==k)
            {
            lst.add(new ArrayList<>(subset));
            return true;
            }
            return false;
        }
        subset.add(nums[idx]);
        sum+=nums[idx];
        if(recursion(idx+1, nums, subset, lst, sum,k)) return true;
        subset.remove(subset.size()-1);
        sum-=nums[idx];
        if(recursion(idx+1, nums, subset, lst, sum,k)) return true;

        return false;
    }
    public static void main(String[] args) {
        int[] nums={1,2,1};
        int k=2;
        System.out.println(subsequence(nums, k));
    }
}
