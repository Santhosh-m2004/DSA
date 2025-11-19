package leetcode;

/**
 * Problem: Merge Intervals (LeetCode 56)
 *
 * You are given an array of intervals where intervals[i] = [start, end].
 * Your task is to merge all overlapping intervals and return the result array.
 *
 * Approach (Greedy + Sorting):
 * - Sort intervals based on start value.
 * - Traverse the sorted list and compare current interval with the last merged one.
 * - If overlapping, merge by updating the end time to the maximum.
 * - Otherwise, add current interval to result list.
 *
 * Time Complexity:  O(n log n)  (sorting)
 * Space Complexity: O(n)
 */

import java.util.*;

public class lt56 {

    public static int[][] merge(int[][] intervals) {
        ArrayList<int[]> lst = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] cur = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= cur[1]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } 
            else {
                lst.add(cur);
                cur = intervals[i];
            }
        }

        lst.add(cur);

        return lst.toArray(new int[lst.size()][]);
    }

    public static void main(String[] args) {


        int[][] intervalsTrue  = {{1,3}, {2,6}, {8,10}, {15,18}};
        // Expected: [[1,6], [8,10], [15,18]]

        int[][] intervalsFalse = {{1,4}, {4,5}};
        // Expected: [[1,5]]

        System.out.println("Test Case 1 -> " + Arrays.deepToString(merge(intervalsTrue)));
        System.out.println("Test Case 2 -> " + Arrays.deepToString(merge(intervalsFalse)));
    }
}
