package Array;

/*You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
You should return the array of nums such that the the array follows the given conditions:
Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions. */
import java.util.*;
public class RearrangeArrayElementsbySign {

    static int[] res(int[] nums){
        int n=nums.length;
        int[] pos=new int[n/2];
        int[] neg=new int[n/2];
        int[] res=new int[n];
        int posi=0;
        int nega=0;
        for(int num:nums){
            if(num>0){
                pos[posi++]=num;
            }else if(num<0){
                neg[nega++]=num;
            }
        }
        int i=0;
        for(int j=0;j<n/2;j++){
            res[i]=pos[j];
            i++;
            res[i]=neg[j];
            i++;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums={3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(res(nums)));
    }
}
