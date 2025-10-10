package leetcode;

public class lt50 {
    public static double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return pow(x, N);
    }

    public static double pow(double x, long N) {
        if (N == 0) return 1;
        double half = pow(x, N / 2);
        if (N % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        double x = 2.0;
        int n = -3;
        System.out.println(myPow(x, n));
    }
}
