/*Given an array of positive integers. We need to make the given array a ‘Palindrome’. 
The only allowed operation is”merging” (of two adjacent elements). 
Merging two adjacent elements means replacing them with their sum. 
The task is to find the minimum number of merge operations required to make the given array a ‘Palindrome’.
 */

import java.util.*;
public class mergePalindrome{
    public static int merge(int[] nums,int n){
        int ans=0;
        for(int i=0,j=nums.length-1;i<=j;){
            if(nums[i]==nums[j]){
                i++;
                j--;
            }
            else if(nums[i]<nums[j]){
                i++;
                nums[i]+=nums[i-1];
                ans++;
            }else{
                j--;
                nums[j]+=nums[j+1];
                ans++;
            }
        }
        return ans;

    }
    public static void main(String[] args)
    {
        int nums[] = new int[]{1, 4, 5, 9, 1} ;
        System.out.println("Count of minimum operations is "+ merge(nums, nums.length));
    
    }
}
