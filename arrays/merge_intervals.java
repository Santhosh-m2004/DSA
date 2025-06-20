import java.util.*;

class merge_intervals {
    public static int[][] merge(int[][] intervals) {
        // If there's only one or no interval, return as is (no merging needed)
        if (intervals.length <= 1) return intervals;

        // Step 1: Sort the intervals based on the start time (first element of each sub-array)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Initialize a list to store merged intervals
        List<int[]> merged = new ArrayList<>();

        // Step 3: Start with the first interval
        int[] cur = intervals[0];

        // Step 4: Iterate through the rest of the intervals
        for (int i = 1; i < intervals.length; i++) {
            // If the current interval overlaps with the previous one (cur)
            if (cur[1] >= intervals[i][0]) {
                // Merge them by updating the end time to the maximum end time
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                // If no overlap, add the previous interval to the merged list
                merged.add(cur);
                // Move to the next interval
                cur = intervals[i];
            }
        }

        // Add the last merged interval to the list
        merged.add(cur);

        // Convert list to an array and return the result
        return merged.toArray(new int[merged.size()][]);
    }

    // Main method for testing
    public static void main(String[] args) {
        // Sample input
        int[][] intervals = {
            {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };

        // Call the static merge function directly
        int[][] result = merge(intervals);

        // Print the merged intervals
        System.out.println("Merged Intervals:");
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
