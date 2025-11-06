package leetcode;

class lt136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans = ans ^ num;
        }
        return ans;
    }

    public static void main(String[] args) {
        lt136 obj = new lt136();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println("Single Number: " + obj.singleNumber(nums));
    }
}
