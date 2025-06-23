package Strings;
import java.util.*;
public class longestPalindromeString {
    static String res(String s){
        int maxLength=0;
        int start=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isPalindrome(s, i, j) && j-i+1>maxLength){
                    start=i;
                    maxLength=j-i+1;
                }
            }
        }
        return s.substring(start, start+maxLength);
    }
    static boolean isPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(res(s));
    }
}
