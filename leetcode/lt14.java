package leetcode;

import java.util.Arrays;

public class lt14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int ans = 0;
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) == last.charAt(i)) {
                ans++;
            } else {
                break;
            }
        }
        return first.substring(0, ans);
    }

    public static void main(String[] args) {
        lt14 obj = new lt14();

        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println("LCP of " + Arrays.toString(strs1) + " = " + obj.longestCommonPrefix(strs1));

        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println("LCP of " + Arrays.toString(strs2) + " = " + obj.longestCommonPrefix(strs2));

        String[] strs3 = {"interspecies", "interstellar", "interstate"};
        System.out.println("LCP of " + Arrays.toString(strs3) + " = " + obj.longestCommonPrefix(strs3));

        String[] strs4 = {"throne", "dungeon"};
        System.out.println("LCP of " + Arrays.toString(strs4) + " = " + obj.longestCommonPrefix(strs4));

        String[] strs5 = {"throne", "throne"};
        System.out.println("LCP of " + Arrays.toString(strs5) + " = " + obj.longestCommonPrefix(strs5));
    }
}
