package Array;
/*You are given an array of integers nums and an integer k.
A "nice subarray" is defined as a continuous subarray that contains exactly k odd numbers.
Write a function to return the number of nice subarrays in nums. */
import java.util.HashMap;
import java.util.Map;

public class SubarrayCounter {
    public static int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); 

        int count = 0, odd = 0;
        for (int num : nums) {
            if (num % 2 != 0) {
                odd++;
            }
            count += prefixCount.getOrDefault(odd - k, 0);
            prefixCount.put(odd, prefixCount.getOrDefault(odd, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        int result = numberOfSubarrays(nums, k);
        System.out.println("Number of subarrays with exactly " + k + " odd numbers: " + result);
    }
}

