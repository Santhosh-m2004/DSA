package Strings;
import java.util.*;
/*Given a valid parentheses string s, return the nesting depth of s. 
The nesting depth is the maximum number of nested parentheses.
Input: s = "(1+(2*3)+((8)/4))+1"
Output: 3
Explanation:
Digit 8 is inside of 3 nested parentheses in the string. */
public class MaxNestingDepthofParentheses {
    static int res(String s){
        int count=0;
        int curCount=0;
        char[] ch=new char[s.length()];
        int idx=0;
        for(char c:s.toCharArray()){
            ch[idx++]=c;
        }
        for(int i=0;i<s.length();i++){
            if(ch[i]=='('){
                curCount++;
                count=Math.max(count,curCount);
            }else if(ch[i]==')'){
                curCount--;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(res(s));
    }
}
