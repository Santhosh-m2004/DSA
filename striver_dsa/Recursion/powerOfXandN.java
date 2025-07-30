package Recursion;
import java.util.*;

public class powerOfXandN {

    public static double res(double x, int n) {
        // Convert to long to avoid overflow when n = Integer.MIN_VALUE
        long N = n;

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        if (N == 0) return 1;

        double half = res(x, (int)(N / 2));

        if (N % 2 == 0) return half * half;
        else return half * half * x;
    }

    public static void main(String[] args) {
        double x = 2.0000;
        int n = -2;
        System.out.println(res(x, n));  // Output: 0.25
    }
}
