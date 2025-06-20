package Array;

public class maxProductSubArray {

    static int maxProduct(int[] nums){
        int n=nums.length;

        int max=0;
        int pre=0;
        int suf=0;
        for(int i=0;i<nums.length;i++){
            if(pre==0) pre=1;
            if(suf==0) suf=1;
            pre=pre*nums[i];
            suf=suf*nums[n-i-1];
            max=Math.max(max,Math.max(pre,suf)); 
        }


        return max;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));

    }
}
