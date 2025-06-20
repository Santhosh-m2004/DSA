package Array;
/*Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets. */

import java.util.*;
public class ThreeSum {
    static List<List<Integer>> res(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;

            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }
                else{
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    while(j<k && nums[j]==nums[j-1]){
                        j++;
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
        System.out.println(res(nums));
    }
}
