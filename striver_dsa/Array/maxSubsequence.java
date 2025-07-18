package Array;

import java.util.Arrays;

public class maxSubsequence {
    public static int[] maxSubsequence(int[] nums, int k) {

        // Step 1: Create a 2D array to store each number with its original index
        // valueWithIndex[i][0] = value of nums[i]
        // valueWithIndex[i][1] = index i
        int[][] valueWithIndex = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            valueWithIndex[i] = new int[]{nums[i], i}; 
        }

        // Step 2: Sort the array by value in descending order
        // This helps us pick the top 'k' largest elements
        Arrays.sort(valueWithIndex, (a, b) -> b[0] - a[0]);

        // Step 3: Now among the top 'k' elements, sort again based on their **original indices**
        // This ensures that the order in the final result is the same as in the original array
        Arrays.sort(valueWithIndex, 0, k, (a, b) -> a[1] - b[1]);

        // Step 4: Extract the first k values (after sorting by index) into result
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = valueWithIndex[i][0];
        }

        // Return the result array which has the max subsequence of size k 
        // in the same order as original input
        return result;
    }
    public static void main(String[] args) {
        int[] nums={-1,-2,3,4}; 
        int k = 3;
        System.out.println(Arrays.toString(maxSubsequence(nums, k)));
    }
}


