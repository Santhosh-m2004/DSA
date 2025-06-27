package Recursion;

public class rough {
    static void f(int n ){
        if(n<1){
            return;
        }
        
        f(n-1);
        System.out.println(n);
    }
    public static void main(String[] args) {
        int n=5;
        f(n);
    }
}
