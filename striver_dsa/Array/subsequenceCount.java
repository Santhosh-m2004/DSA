package Array;
/*You are given an array of integers nums and an integer target.

Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target. 
Since the answer may be too large, return it modulo 109 + 7.

Example 1:
Input: nums = [3,5,6,7], target = 9
Output: 4
Explanation: There are 4 subsequences that satisfy the condition.
[3] -> Min value + max value <= target (3 + 3 <= 9)
[3,5] -> (3 + 5 <= 9)
[3,5,6] -> (3 + 6 <= 9)
[3,6] -> (3 + 6 <= 9) */
import java.util.Arrays;

public class subsequenceCount {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1_000_000_007;
        int count = 0;
        int left = 0, right = nums.length - 1;

        int[] pow = new int[nums.length];
        pow[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                count = (count + pow[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        subsequenceCount sc = new subsequenceCount();
        int[] nums = {27, 21, 14, 2, 15, 1, 19, 8, 12, 24, 21, 8, 12, 10, 11, 30, 15, 18, 28, 14, 26, 9, 2, 24, 23, 11, 7, 12, 9, 17, 30, 9, 28, 2, 14, 22, 19, 19, 27, 6, 15, 12, 29, 2, 30, 11, 20, 30, 21, 20, 2, 22, 6, 14, 13, 19, 21, 10, 18, 30, 2, 20, 28, 22};
        int target = 31;

        int result = sc.numSubseq(nums, target);
        System.out.println("Output: " + result); // 688052206
    }
}
