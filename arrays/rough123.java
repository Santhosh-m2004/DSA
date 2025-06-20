class rough123 {
    public int[] nextGreaterElements(int[] nums) {
        int[] arr1 = new int[2 * nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            arr1[i] = nums[i];
        }
        for (int i = nums.length; i < arr1.length; i++) {
            arr1[i] = nums[i - nums.length];
        }

        return arr1; // Just returns the doubled array for now
    }

    public static void main(String[] args) {
        rough123 sol = new rough123();
        int[] nums = {1, 2, 3};

        int[] result = sol.nextGreaterElements(nums);

        // Print the result
        System.out.print("Doubled Array: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
