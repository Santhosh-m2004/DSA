package bitManipulation;

public class checkingIthBitSetOrNot {
    public static boolean leftShift(int n,int k){
        return (n & (1<<k))!=0;
    }

    public static boolean rightShift(int n,int k){
        return ((n>>k) & 1)!=0;
    }
    public static void main(String[] args) {
        int n=13;
        int k=2;
        System.out.println(leftShift(n,k));
        System.out.println(rightShift(n, k));
    }


}
