/*You are given a 0-indexed array of non-negative integers nums.
For each integer in nums, you must find its respective second greater integer.
The second greater integer of nums[i] is nums[j] such that:j > i   and nums[j] > nums[i]
There exists exactly one index k such that nums[k] > nums[i] and i < k < j.
If there is no such nums[j], the second greater integer is considered to be -1. 
Input: nums = [2,4,0,9,6]
Output: [9,6,6,-1,-1]  */
import java.util.*;
public class nextMaxarray{

    // public static int[] ans(int[] nums){
    //     int[] res=new int[nums.length];
    //     for(int i=0;i<nums.length;i++){
    //         res[i]=-1;
    //         int count=0;
    //         for(int j=i+1;j<nums.length;j++){
    //             if(nums[j]>nums[i])
    //             {
    //                 count++;
    //                 if(count==2){
    //                     res[i]=nums[j];
    //                     break;
    //                 }
    //             }
    //         }
    //     }
    //     return res;
    // }


    public static int[] ans(int[] nums){
        int n=nums.length;
        int[] res=new int[n];
        Stack<Integer> st=new Stack<>();
        Arrays.fill(res, -1);

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[i]>nums[st.peek()]){
                res[st.pop()]=nums[i];
            }
            st.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        str=str.replaceAll("[^0-9,]", "");
        String[] strNums=str.split(",");
        int[] nums=new int[strNums.length];
        for(int i=0;i<strNums.length;i++){
            nums[i]=Integer.parseInt(strNums[i]);
        }
        int[] res=ans(nums);
        System.out.println(Arrays.toString(res));
    }
    
}