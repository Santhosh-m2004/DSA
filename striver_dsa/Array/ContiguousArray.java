package Array;
import java.util.HashMap;
/*Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1. */
public class ContiguousArray {

    static int findMaxLength(int[] nums) {
        int sum = 0, maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : 1;

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 1, 0, 0};
        System.out.println(findMaxLength(nums));
    }
}
