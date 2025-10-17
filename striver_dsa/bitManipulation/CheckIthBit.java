package bitManipulation;

public class CheckIthBit {

    public static boolean isIthBitSet(int n, int i) {
        return (n & (1 << i)) != 0; 
    }

    public static void main(String[] args) {
        int n = 13; // binary 1101
        int i = 2;  // checking 2nd bit (0-indexed from right)

        if (isIthBitSet(n, i))
            System.out.println("Bit " + i + " is SET (1)");
        else
            System.out.println("Bit " + i + " is NOT SET (0)");
    }
}
