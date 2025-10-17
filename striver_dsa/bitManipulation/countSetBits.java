package bitManipulation;

public class countSetBits {

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) { // check last bit
                count++;
            }
            n = n >> 1; // right shift
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 13; // binary 1101
        System.out.println(countSetBits(n)); // Output: 3
    }
}
