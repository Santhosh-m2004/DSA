package Recursion;
import java.util.*;
//Given a string, find all the possible subsequences of the string.
public class printAllSubsequences {

    public static List<List<Integer>> res(int[] nums){
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        createSubset(nums,0,subset,res);
        return res;
    }
    public static void createSubset(int[] nums,int idx,List<Integer> subset,List<List<Integer>> res){
        if(idx==nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[idx]);
        createSubset(nums, idx+1, subset, res);
        subset.remove(subset.size()-1);
        createSubset(nums, idx+1, subset, res);
    }
    public static void main(String[] args) {
        int [] nums={1,2,3};
        System.out.print(res(nums));
    }
}
