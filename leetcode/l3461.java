package leetcode;
import java.util.*;


class l3461 {
    public static boolean hasSameDigits(String s) {
        String temp = s;

        while (temp.length() > 2) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < temp.length() - 1; i++) {
                int a = temp.charAt(i) - '0';
                int b = temp.charAt(i + 1) - '0';
                sb.append((a + b) % 10);
            }

            temp = sb.toString();
        }

        if (temp.length() < 2) return false;
        return temp.charAt(0) == temp.charAt(1);
    }
    public static void main(String[] args) {
        System.out.println(hasSameDigits(String.valueOf(3902)));
        System.out.println(hasSameDigits(String.valueOf(34789)));
    }
}

