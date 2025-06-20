package Strings;
import java.util.*;
// for string not having any characters between them.
class paranthesis {
    public static boolean isValid(String s) {
        Stack<Character> st=new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='('||c== '{'||c=='['){
                st.push(c);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                char d=st.pop();
                if((d=='{'&& c=='}') ||( d=='('&& c==')') || (d=='[' && c==']')){
                    continue;
                }else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s="([])";
        System.out.println(isValid(s));
    }
}

//for strings involving characters
/* 
package Strings;
import java.util.*;

class Paranthesis {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (char c : s.toCharArray()) {
            // Skip all characters that are not brackets
            if (c != '(' && c != ')' && c != '{' && c != '}' && c != '[' && c != ']') {
                continue;
            }

            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                char d = st.pop();
                if ((d == '(' && c == ')') || (d == '{' && c == '}') || (d == '[' && c == ']')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([a+b]*c)";  // Contains other characters
        System.out.println(isValid(s)); // true

        String s2 = "([5+3]*c)";  // Contains numbers and other characters
        System.out.println(isValid(s2)); // true

        String s3 = "([)]";  // Incorrect nesting
        System.out.println(isValid(s3)); // false
    }
}
*/