package bitManipulation;

public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        // A number is power of 2 if only one bit is set in its binary form
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int n = 16; // Try changing this value

        if (isPowerOfTwo(n))
            System.out.println(n + " is a Power of 2");
        else
            System.out.println(n + " is NOT a Power of 2");
    }
}
