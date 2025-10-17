package bitManipulation;

public class RightmostBitOperations {

    // Set the rightmost UNSET bit (0 -> 1)
    public static int setRightmostUnsetBit(int n) {
        if (n == 0)
            return 1; // 0000 -> 0001
        return n | (n + 1);
    }

    // Unset the rightmost SET bit (1 -> 0)
    public static int unsetRightmostSetBit(int n) {
        return n & (n - 1);
    }

    public static void main(String[] args) {
        int n = 13; // binary: 1101

        System.out.println("Original number: " + n + " (" + Integer.toBinaryString(n) + ")");

        int setResult = setRightmostUnsetBit(n);
        System.out.println("After setting rightmost UNSET bit : " + setResult + " (" + Integer.toBinaryString(setResult) + ")");

        int unsetResult = unsetRightmostSetBit(n);
        System.out.println("After unsetting rightmost SET bit : " + unsetResult + " (" + Integer.toBinaryString(unsetResult) + ")");
    }
}
