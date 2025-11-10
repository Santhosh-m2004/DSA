package leetcode;

public class lt930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;

        while (right < nums.length) {
            sum += nums[right];
            right++;

            while (sum > goal) {
                sum -= nums[left];
                left++;
            }

            count += (right - left);
        }

        return count;
    }

    public static void main(String[] args) {
        lt930 sol = new lt930();
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(sol.numSubarraysWithSum(nums, goal)); // Output: 4
    }
}
