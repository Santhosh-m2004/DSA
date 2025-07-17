package stack;
import java.util.*;
import java.util.Arrays;

public class nextGreaterElement1 {
    public static int[] nge(int[] nums1,int[] nums2){
        Stack<Integer> st=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
            if(st.isEmpty()){
                st.push(nums2[i]);
                map.put(nums2[i], -1);
            }else{
                if(st.peek()>nums2[i]){
                    map.put(nums2[i],st.peek());
                    st.push(nums2[i]);
                    continue;
                }else{
                    while(!st.isEmpty() && st.peek()<nums2[i]){
                        st.pop();
                    }
                    if(st.isEmpty()){
                        map.put(nums2[i],-1);
                    }else{
                        map.put(nums2[i],st.peek());
                        st.push(nums2[i]);
                    }
                }
            }
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i]=map.get(nums1[i]);
        }

        return nums1;
    }
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nge(nums1, nums2)));

        int[] nums3 = {2,4};
        int[] nums4 = {1,2,3,4};
        System.out.println(Arrays.toString(nge(nums3, nums4)));


    }
}
