package leetcode;

import java.util.*;

/*3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without duplicate characters.
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. */

public class l3 {

    public static int res(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int left = 0, maxlen = 0;

        for (int right = 0; right < n; right++) {
            // If character already in set, move left pointer until it's removed
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            // Add current character and update max length
            set.add(s.charAt(right));
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(res(s)); // Output: 3
    }
}
