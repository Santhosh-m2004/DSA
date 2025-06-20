/*Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
Since the result may be very large, so you need to return a string instead of an integer.
Example 1
Input: nums = [10,2]
Output: "210"
Example 2:
Input: nums = [3,30,34,5,9]
Output: "9534330" */

import java.util.Arrays;

public class largestNumber {
    public static String largestNumber(int[] nums) {
        String[] str=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            str[i]=String.valueOf(nums[i]);
        }

        Arrays.sort(str,(a,b)-> (b+a).compareTo(a+b));

        if(str[0].equals("0")){
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        for(String num:str){
            sb.append(num);
        }
        return sb.toString();

    }
    public static void main(String[] args) {
        int[] nums={3,8,5,21,54};
        System.out.println(largestNumber(nums));
}
}