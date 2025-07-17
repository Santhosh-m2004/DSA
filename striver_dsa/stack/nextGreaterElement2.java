package stack;
import java.util.*;
import java.util.Arrays;

public class nextGreaterElement2 {
    public static int[] nge(int[] nums){
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] res=new int[n];
        for(int i=2*n-1;i>=0;i--){
            if(st.isEmpty()){
                st.push(nums[i]);
                map.put(nums[i],-1);
            }else{
                if(st.peek() <nums[i]){
                    while(st.isEmpty() && st.peek()<nums[i%n]){
                        st.pop();
                    }
                }else{
                    st.push(nums[i%n]);
                    map.put(nums[i],st.peek());
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,3,4,2};
        System.out.println(Arrays.toString(nge(nums1)));

        int[] nums2 = {1,2,3,4};
        System.out.println(Arrays.toString(nge(nums2)));
    }
}
