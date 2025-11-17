package leetcode;

/**
 * Problem: Assign Cookies (LeetCode 455)
 *
 * You are given two integer arrays:
 *   g[] -> greed factor of each child
 *   s[] -> size of each cookie
 *
 * A child i will be content if they receive a cookie with size >= g[i].
 * Each child can get at most one cookie and each cookie can be assigned once.
 *
 * Goal:
 *   Return the maximum number of children that can be made content.
 *
 * Approach:
 *   1. Sort both arrays
 *   2. Use two pointers to match the smallest possible cookie to the least greedy child
 *   3. Greedy strategy: always satisfy the child with the smallest greed first
 *
 * Time Complexity:  O(n log n + m log m)
 * Space Complexity: O(1)
 */

import java.util.*;

public class lt455 {

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0, cnt = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                cnt++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] g = {1, 2, 3};  // greed factors of children
        int[] s = {1, 1};     // cookie sizes

        int ans = findContentChildren(g, s);
        System.out.println("Number of content children = " + ans);
    }
}
