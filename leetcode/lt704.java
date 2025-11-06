package leetcode;

public class lt704 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        lt704 sol = new lt704();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        int target2 = 2;
        System.out.println(sol.search(nums, target1)); // 4
        System.out.println(sol.search(nums, target2)); // -1
    }
}
