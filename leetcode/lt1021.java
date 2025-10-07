package leetcode;
import java.util.*;

public class lt1021 {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                if (count > 0) {
                    sb.append(s.charAt(i));
                }
                count++;
            } else {
                if (count > 1) {
                    sb.append(s.charAt(i));
                }
                count--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        lt1021 solution = new lt1021();

        String s1 = "(()())(())";
        String s2 = "(()())(())(()(()))";
        String s3 = "()()";

        System.out.println("Input: " + s1 + " -> Output: " + solution.removeOuterParentheses(s1));
        System.out.println("Input: " + s2 + " -> Output: " + solution.removeOuterParentheses(s2));
        System.out.println("Input: " + s3 + " -> Output: " + solution.removeOuterParentheses(s3));
    }
}
