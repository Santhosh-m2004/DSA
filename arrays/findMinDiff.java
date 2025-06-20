// Chocolate Distribution Problem
// Given an array arr[] of n integers where arr[i] represents the number of chocolates in ith packet.
//  Each packet can have a variable number of chocolates. 
// There are m students, the task is to distribute chocolate packets such that: 
// Each student gets exactly one packet.
// The difference between the maximum and minimum number of chocolates in the packets given to the students is minimized.

import java.util.Arrays; // Importing Arrays class for sorting

class GfG {  // Class name

    // Function to find the minimum difference
    static int findMinDiff(int[] arr, int m) {
        int n = arr.length; // Number of packets

        // Sort the given packets (helps in picking contiguous values)
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE; // Initialize minDiff with a large value

        // Traverse through the sorted array using a sliding window of size 'm'
        for (int i = 0; i + m - 1 < n; i++) {

            // Difference between the max and min chocolate count in current window
            int diff = arr[i + m - 1] - arr[i];

            // Update minDiff if a smaller difference is found
            if (diff < minDiff)
                minDiff = diff;
        }
        return minDiff; // Return the minimum difference found
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 56}; // Chocolate packets
        int m = 3; // Number of students

        // Output the minimum difference
        System.out.println(findMinDiff(arr, m));
    }
}
