package Strings;
import java.util.*;
class atoi {
    public static int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;

        int i = 0;
        int sign = 1;
        int res = 0;

        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + digit;
            i++;
        }

        return res * sign;
    }
    public static void main(String[] args) {
        String s="-13232n";
        System.out.println(myAtoi(s));
    }
}

