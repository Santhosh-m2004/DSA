package leetcode;

/**
 * Problem: N Meetings in One Room
 *
 * You are given two integer arrays: start[] and end[], where:
 *  - start[i] = starting time of the i-th meeting
 *  - end[i]   = ending time of the i-th meeting
 *
 * Only one meeting can take place at a time in a single meeting room.
 * Find the **maximum number of meetings** that can be performed.
 *
 * Greedy Strategy:
 * - Create meeting objects storing {start, end, index}
 * - Sort meetings by their end time (earliest finishing first)
 * - Select a meeting if its start time is greater than the last selected meeting's end time
 *
 * Time Complexity:  O(n log n)  (due to sorting)
 * Space Complexity: O(n)
 */

import java.util.*;

public class ltNMeetings {

    static class Node {
        int start;
        int end;
        int idx;
        Node(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }
    }

    public static int maxMeetings(int[] start, int[] end) {
        Node[] arr = new Node[start.length];
        for (int i = 0; i < start.length; i++) {
            arr[i] = new Node(start[i], end[i], i + 1);
        }

        Arrays.sort(arr, (a, b) -> a.end - b.end);

        int count = 1;
        int freeTime = arr[0].end;

        for (int i = 1; i < start.length; i++) {
            if (arr[i].start > freeTime) {
                count++;
                freeTime = arr[i].end;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] startTrue  = {1, 3, 0, 5, 8, 5};
        int[] endTrue    = {2, 4, 6, 7, 9, 9}; // Expected: 4

        int[] startFalse = {1, 2, 3};  
        int[] endFalse   = {4, 4, 4};        // Expected: 1

        System.out.println("Test Case 1 -> " + maxMeetings(startTrue, endTrue));
        System.out.println("Test Case 2 -> " + maxMeetings(startFalse, endFalse));
    }
}
