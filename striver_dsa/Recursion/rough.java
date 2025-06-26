package Recursion;

public class rough {
    static void f(int n,int count){
        if(count==n){
            return;
        }
        System.out.println("Santhosh");
        f(n,count+1);
    }
    public static void main(String[] args) {
        int n=5;
        int count=0;
        f(n,count);
    }
}
