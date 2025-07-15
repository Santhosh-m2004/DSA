package Recursion;

public class palindrome {
    public static boolean palindrome(String s,int i,int j){
        if(i>=j){
            return true;
        }
        if(s.charAt(i)!=s.charAt(j)){
            return false;
        }
        return palindrome(s, i+1, j-1);
    }
    public static void main(String[] args) {
        String s1="abcba";
        String s2="amam";
        System.out.println(palindrome(s1,0,s1.length()-1));
        System.out.println(palindrome(s2,0,s2.length()-1));

    }
}
