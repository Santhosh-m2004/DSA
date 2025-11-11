package leetcode;

import java.util.*;

public class lt76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }

        int req = mapT.size();
        int found = 0;
        int start = 0;
        int end = 0;
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            char ch = s.charAt(right);
            mapS.put(ch, mapS.getOrDefault(ch, 0) + 1);

            if (mapT.containsKey(ch) && mapS.get(ch).intValue() == mapT.get(ch).intValue()) {
                found++;
            }

            while (left <= right && found == req) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                    end = right;
                }

                char leftChar = s.charAt(left);
                mapS.put(leftChar, mapS.get(leftChar) - 1);

                if (mapT.containsKey(leftChar) && mapS.get(leftChar) < mapT.get(leftChar)) {
                    found--;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        lt76 sol = new lt76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(sol.minWindow(s, t)); // ✅ Expected Output: "BANC"
    }
}
