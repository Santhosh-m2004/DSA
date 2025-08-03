package practice;
import java.util.*;
public class p8 {
    public static ArrayList<Integer> res(int[] nums){
        int n=nums.length;
        int count1=0;
        int count2=0;
        int ele1=Integer.MIN_VALUE;
        int ele2=Integer.MIN_VALUE;
        ArrayList<Integer> lst=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(count1==0 && nums[i]!=ele2){
                count1=1;
                ele1=nums[i];
            }
            else if(count2==0 && nums[i]!=ele1){
                count2=1;
                ele2=nums[i];
            }
            else if(nums[i]==ele1){
                count1++;
            }else if(nums[i]==ele2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;
        for(int i=0;i<n;i++){
            if(nums[i]==ele1){
                count1++;
            }
            else if(nums[i]==ele2){
                count2++;
            }
        }

        int min=n/3;
        if(count1>min){
            lst.add(ele1);
        }
        if(count2>min){
            lst.add(ele2);
        }

        return lst;
    }
    public static void main(String[] args) {
        int[] arr={1,2,1,2,3,1,1,2,2};
        System.out.println(res(arr));
    }
}
