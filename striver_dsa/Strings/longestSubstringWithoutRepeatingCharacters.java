package Strings;

import java.util.HashSet;

public class longestSubstringWithoutRepeatingCharacters {
    public static int res(String s){
        HashSet<Character> set=new HashSet<>();
        int left=0;
        int right=0;
        int max=0;
        while(right<s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                max=Math.max(max,right-left);
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    
    }
    public static void main(String[] args) {
        String s ="abcabcdabc";
        System.out.println(res(s));
    }
}
