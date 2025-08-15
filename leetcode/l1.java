package leetcode;
import java.util.*;
public class l1 {
    public static List<Integer> res(int[] nums,int target){
        List<Integer> lst=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if(map.containsKey(complement)){
                lst.add(map.get(complement));
                lst.add(i);
            }
            map.put(nums[i],i);
        }
        return lst;
    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(res(nums,target));
    }
}
