package leetcode;

/**
 * Problem: Non-overlapping Intervals (LeetCode 435)
 *
 * You are given an array of intervals where each interval has a start and end time.
 * Your task is to remove the minimum number of intervals so that the remaining
 * intervals do not overlap.
 *
 * Strategy (Greedy):
 * - Sort intervals based on their end time (ascending).
 * - Always keep the interval that ends earliest.
 * - If the next interval overlaps with the selected interval,
 *   remove it and increase the removal count.
 *
 * Time Complexity:  O(n log n)  (sorting)
 * Space Complexity: O(1)
 */

import java.util.*;

public class lt435 {

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int cnt = 0;
        int[] cur = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (cur[1] > intervals[i][0]) {
                cnt++;
            } else {
                cur = intervals[i];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

        int[][] intervalsTrue  = {{1,2}, {2,3}, {3,4}, {1,3}}; // Expected output: 1
        int[][] intervalsFalse = {{1,2}, {2,3}};               // Expected output: 0

        System.out.println("Test Case 1 -> " + eraseOverlapIntervals(intervalsTrue));
        System.out.println("Test Case 2 -> " + eraseOverlapIntervals(intervalsFalse));
    }
}
