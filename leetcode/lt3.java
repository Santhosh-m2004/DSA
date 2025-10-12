package leetcode;
import java.util.*;
class lt3 {
    public static int lengthOfLongestSubstring(String s) {
        int[] fq=new int[256];
        int left=0;
        int right=0;
        int maxLen=0;

        while(right<s.length()){
            char ch=s.charAt(right);
            fq[ch]++;
            right++;

            while(fq[ch]>1){
                char c=s.charAt(left);
                fq[c]--;
                left++;
            }

            maxLen=Math.max(maxLen,right-left);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}