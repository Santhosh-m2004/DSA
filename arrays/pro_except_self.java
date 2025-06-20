import java.util.*;
public class pro_except_self {
    public static int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int[] pre=new int[n];
        int[] suf=new int[n];
        pre[0]=1;
        suf[n-1]=1;
        
        
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]*nums[i-1];
        } 
        for(int i=n-2;i>=0;i--){
            suf[i]=suf[i+1]*nums[i+1];
        }
        for(int i=0;i<n;i++){
            ans[i]=pre[i]*suf[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
// without using extra space(not using separate arrays for storing prefix and suffix)
    /*public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int[] pre=new int[n];
        int[] suf=new int[n];
        ans[0]=1;
        
        
        for(int i=1;i<n;i++){
            ans[i]=ans[i-1]*nums[i-1];
        } 
        int suffix=1;
        for(int i=n-2;i>=0;i--){
            suffix*=nums[i+1];
            ans[i]*=suffix;
        }
        
        return ans;
    } */

}
