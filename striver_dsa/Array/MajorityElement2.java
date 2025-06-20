package Array;
import java.util.*;

public class MajorityElement2 {
    static int[] res(int[] nums){
        ArrayList<Integer> list = new ArrayList<>();
        int count1 = 0, count2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && nums[i] != ele2) {
                ele1 = nums[i];
                count1 = 1;
            } else if (count2 == 0 && nums[i] != ele1) {
                ele2 = nums[i];
                count2 = 1;
            } else if (nums[i] == ele1) {
                count1++;
            } else if (nums[i] == ele2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // Recount the actual occurrences
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == ele1) count1++;
            else if (num == ele2) count2++;
        }

        int reqlen = nums.length / 3;
        if (count1 > reqlen) list.add(ele1);
        if (count2 > reqlen) list.add(ele2);

        // Convert list to int[]
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
    int[] nums = {3,3,1};
        System.out.println(Arrays.toString(res(nums))); 
    }
}
