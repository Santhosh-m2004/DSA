/*Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.*/
package Array;
import java.util.*;

public class RotateArrayByK {

    public static int[] res(int [] nums,int k){
        int n=nums.length;
        k=k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
        return nums;
    }
    static void reverse(int[] nums,int start,int end){
        
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] nums={1,2,4,6,3};
        int k=2;
        System.out.println(Arrays.toString(res(nums,k)));
    }
}
