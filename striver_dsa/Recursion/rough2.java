package Recursion;

public class rough2 {
    public static void prg(int n,int count){
        if(n<1){
            System.out.println(count);
            return;
        }
        prg(n-1,count+n);
    }
    public static void main(String[] args) {
        prg(3,0);
    }
}
