package stack;

import java.util.Arrays;
import java.util.Stack;

public class asteroidColllision {
    public static int[] res(int[] nums){
        Stack<Integer> st=new Stack<>();
        for(int num:nums){
            boolean destroyed=false;
            while(!st.isEmpty() && num<0 && st.peek()>0){
                if(st.peek()<-num){
                    st.pop();
                }
                else if(st.peek()==-num){
                    st.pop();
                    destroyed=true;
                    break;
                }
                else{
                    destroyed=true;
                    break;
                }
            }
            if(!destroyed){
                st.push(num);
            }
        }
        int[] res = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums={1,5,-1,-5};
        System.out.println(Arrays.toString(res(nums)));
    }
}
