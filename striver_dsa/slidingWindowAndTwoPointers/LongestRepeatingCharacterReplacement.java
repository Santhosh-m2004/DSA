package slidingWindowAndTwoPointers;
import java.util.*;
/*You are given a string s and an integer k. 
You can choose any character of the string and change it to any other uppercase English character. 
You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.
Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
*/

public class LongestRepeatingCharacterReplacement {
    public static int res(String s,int k){
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int maxfq=0;
        int maxlen=0;
        for(int right=0;right<s.length();right++){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right), 0)+1);
            maxfq=Math.max(maxfq,map.get(s.charAt(right)));
            while((right-left+1)-maxfq > k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }
            maxlen=Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(res(s, k));
    }
}
