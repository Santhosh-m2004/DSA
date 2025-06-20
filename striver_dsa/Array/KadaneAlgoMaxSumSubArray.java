package Array;
import java.util.*;

public class KadaneAlgoMaxSumSubArray {
    static int res(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        int start = 0;       // temp start index
        int ansStart = 0;    // final start index of subarray
        int ansEnd = 0;      // final end index of subarray

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum > maxSum) {
                maxSum = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }

        // Print the subarray
        System.out.print("Max sum subarray: ");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, -1, 7, 8};
        System.out.println("Max sum: " + res(nums));
    }
}
