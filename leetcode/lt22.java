package leetcode;

import java.util.*;

public class lt22 {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recursion(n, 0, 0, res, "");
        return res;
    }

    public static void recursion(int n, int open, int close, List<String> res, String str) {
        if (str.length() == 2 * n) {
            res.add(str);
            return;
        }
        if (open < n) {
            recursion(n, open + 1, close, res, str + '(');
        }
        if (close < open) {
            recursion(n, open, close + 1, res, str + ')');
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}
