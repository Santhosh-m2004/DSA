/*Given an integer array nums, move all 0's to the end of it while maintaining the 
relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array. */
package Array;
import java.util.*;
public class moveZeroes {

    public static int[] ans(int[] nums){
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j]=nums[i];
                j++;
            }
        }
        for(int i=j;i<nums.length;i++){
            nums[i]=0;
        }
       
        return nums;
    }
    public static void main(String[] args) {
        int[] nums={1,1,0,0,2};
        System.out.println(Arrays.toString(ans(nums)));

    }
}
