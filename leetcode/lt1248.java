package leetcode;

public class lt1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    public int helper(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int right = 0;
        int ans = 0;

        while (right < nums.length) {
            if (nums[right] % 2 != 0) {
                count++;
            }
            right++;

            while (count > k && left < right) {
                if (nums[left] % 2 != 0) {
                    count--;
                }
                left++;
            }

            ans += right - left;
        }
        return ans;
    }

    public static void main(String[] args) {
        lt1248 sol = new lt1248();
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(sol.numberOfSubarrays(nums, k)); // Output: 2
    }
}
