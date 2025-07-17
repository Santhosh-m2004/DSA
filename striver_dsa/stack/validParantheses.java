package stack;

import java.util.Stack;

public class validParantheses {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
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
        String input = "{[()]}";
        if (isValid(input)) {
            System.out.println("Valid parentheses");
        } else {
            System.out.println("Invalid parentheses");
        }
    }
}
