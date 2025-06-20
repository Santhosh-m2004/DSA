package Strings;
import java.util.*;

public class maxWindowSubstring {
    public static String smallestWindow(String s, String t) {
        if(t.length()>s.length()) return "";

        int left=0;
        int right=0;
        int start=-1;
        int matchedCount=0;
        int minLength=Integer.MAX_VALUE;
        int[] required=new int[128];
        for(char c:t.toCharArray()){
            required[c]++;
        }

        while(right<s.length()){
            char rightChar=s.charAt(right);

            if(required[rightChar]>0){
                matchedCount++;
            }

            required[rightChar]--;
            right++;
            while(matchedCount==t.length()){
                if(right-left<minLength){
                    minLength=right-left;
                    start=left;
                }

                char leftChar=s.charAt(left);
                required[leftChar]++;

                if(required[leftChar]>0){
                    matchedCount--;
                }
                left++;
            }
        }
        if(start==-1){
            return "";
        }
        return s.substring(start,start+ minLength);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String result = smallestWindow(s, t);
        System.out.println("Smallest window: " + result);
    }
}
