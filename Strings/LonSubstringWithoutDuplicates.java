package Strings;
import java.util.HashSet;
//Program to find the length of longest substring without duplicate characters
public class LonSubstringWithoutDuplicates {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int left=0;
        int right=0;
        int maxLength=0;
        while(right<s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLength=Math.max(maxLength,right-left+1);
                right++;
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String  s="abcabcdabcde";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
/*Program to find the longest substring without duplicate characters

public class LonSubstringWithoutDuplicates {
    public static String longestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int maxLength = 0, start = 0;
        
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                if (right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    start = left;
                }
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String s = "abcabcdabcde";
        System.out.println("Longest Substring Without Duplicates: " + longestSubstring(s));
    }
}
 */