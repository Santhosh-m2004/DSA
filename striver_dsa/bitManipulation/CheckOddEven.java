package bitManipulation;

public class CheckOddEven {

    public static boolean isEven(int n) {
        return (n & 1) == 0;  // If last bit is 0 → even
    }

    public static boolean isOdd(int n) {
        return (n & 1) == 1;  // If last bit is 1 → odd
    }

    public static void main(String[] args) {
        int n = 13;

        if (isEven(n))
            System.out.println(n + " is Even");
        else
            System.out.println(n + " is Odd");
    }
}
