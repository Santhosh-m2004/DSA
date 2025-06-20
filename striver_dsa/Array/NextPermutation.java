package Array;

import java.util.Arrays;

public class NextPermutation {

    static int[] res(int[] nums){
        int n=nums.length;
        int idx=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx=i;
                break;
            }
        }
        if(idx==-1){
            int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        }
        else{
            for(int i=n-1;i>idx;i--){
                if(nums[i]>nums[idx]){
                    int temp=nums[i];
                    nums[i]=nums[idx];
                    nums[idx]=temp;
                    break;
                }
            }
        }
        Arrays.sort(nums,idx+1,n);

        return nums;
    }
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(Arrays.toString(res(nums)));
    }
}
