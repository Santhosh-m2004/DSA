package Recursion;
import java.util.*;

public class subsetSum1 {
    public static List<Integer> subsum1(int[] nums){
        List<Integer> res = new ArrayList<>();
        subset(nums, 0, 0, res);
        Collections.sort(res);
        return res;
    }

    public static void subset(int[] nums, int idx, int currSum, List<Integer> res){
        if(idx == nums.length){
            res.add(currSum);
            return;
        }

        // Include nums[idx]
        subset(nums, idx + 1, currSum + nums[idx], res);

        // Exclude nums[idx]
        subset(nums, idx + 1, currSum, res);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3};
        System.out.println(subsum1(nums));
    }
}
