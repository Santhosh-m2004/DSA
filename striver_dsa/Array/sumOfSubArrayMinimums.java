package Array;


class sumOfSubArrayMinimums {
    public static int sumSubarrayMins(int[] arr) {
        long sum = 0;
        long MOD = (long)1e9 + 7;

        for (int i = 0; i < arr.length; i++) {
            int[] temp = new int[arr.length];
            int idx = 0;
            int min=arr[i];
            for (int j = i; j < arr.length; j++) {
                temp[idx++] = arr[j];
                min=Math.min(min,arr[j]);
                sum = (sum + min) % MOD;
            }
        }

        return (int) sum;
    }

    public static void main(String[] args) {
        int[] nums={11,81,94,43,3};
        System.out.println(sumSubarrayMins(nums));
    }
}
