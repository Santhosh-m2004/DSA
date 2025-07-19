package stack;

import java.util.*;

/*Given string num representing a non-negative integer num, and an integer k, 
return the smallest possible integer after removing k digits from num.
Example 1: Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2: Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes. */
public class removeKDigits {
    public static String remove(String s, int k){
        Stack<Character> st=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && k>0 && st.peek() > s.charAt(i)){
                st.pop();
                k--;
            }
            st.push(s.charAt(i));
        }
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }

        List<Character> lst=new ArrayList<>();
        while(!st.isEmpty()){
            lst.add(st.pop());
        }
        Collections.reverse(lst);

        StringBuilder sb=new StringBuilder();
        boolean leadingZeroes=true;
        for(char c:lst){
            if(leadingZeroes && c=='0') continue;
            leadingZeroes=false;
            sb.append(c);
        }

        return sb.length()==0 ? "0" : sb.toString();

    }
    public static void main(String[] args) {
        String s="1432219";
        int k = 3;
        System.out.println(remove(s,k));
    }
}
