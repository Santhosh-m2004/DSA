package Strings;
import java.util.*;
/*You are given a string s, which contains stars *.

In one operation, you can:

Choose a star in s.
Remove the closest non-star character to its left, as well as remove the star itself.
Return the string after all stars have been removed */

class removeStar {
    public String removeStars(String s) {
        char[] ch=s.toCharArray();
        Stack<Character> st=new Stack<>();
        for(char c:ch){
            if(c=='*'){
                st.pop();
            }else{
            st.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            sb.append(c);
        }

        return sb.toString();
    }
    
    public static void main(String[] args) {
        removeStar obj=new removeStar();
        System.out.println(obj.removeStars("f*gh*ij*"));
        
    }
}