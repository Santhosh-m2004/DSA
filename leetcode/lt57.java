package leetcode;

import java.util.*;

public class lt57 {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newArr = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            newArr[i] = intervals[i];
        }
        newArr[intervals.length] = newInterval;
        ArrayList<int[]> merged = merge(newArr);
        return merged.toArray(new int[merged.size()][]);
    }

    public static ArrayList<int[]> merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= cur[1]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                list.add(cur);
                cur = intervals[i];
            }
        }
        list.add(cur);
        return list;
    }

    public static void main(String[] args) {
        int[][] intervalsTrue  = {{1,3},{6,9}};
        int[] newIntervalTrue  = {2,5};

        int[][] intervalsFalse = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newIntervalFalse = {4,8};

        System.out.println("Test Case 1 -> " + Arrays.deepToString(insert(intervalsTrue, newIntervalTrue)));
        System.out.println("Test Case 2 -> " + Arrays.deepToString(insert(intervalsFalse, newIntervalFalse)));
    }
}
