

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int total=nums[i]+nums[j]+nums[k];
                if(total>0){
                    k--;
                }else if(total<0){
                    j++;
                }else{
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    while(j<k && nums[j]==nums[j-1]){
                        j++;
                    }
                }
            }

        }
        return list;       
    }

    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = obj.threeSum(nums);
        System.out.println(result);
    }
}
