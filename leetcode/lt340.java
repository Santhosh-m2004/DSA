package leetcode;
import java.util.*;
/*You are given a string s and an integer k.
Your task is to find the length of the longest substring 
    that contains at most k distinct characters.
Input: s = "eceba", k = 2  
Output: 3
Explanation:
Substrings with at most 2 distinct characters:
"ece" → has {e, c} → length 3 ✅
"ba" → has {b, a} → length 2
✅ Longest = 3 */

public class lt340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int right=0;
        int maxLen=0;
        while(right<s.length()){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right), 0)+1);

            while(map.size()>k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        lt340 sol = new lt340();

        String s1 = "eceba";
        int k1 = 2;
        System.out.println(sol.lengthOfLongestSubstringKDistinct(s1, k1)); // 3

        String s2 = "aa";
        int k2 = 1;
        System.out.println(sol.lengthOfLongestSubstringKDistinct(s2, k2)); // 2
    }
}

