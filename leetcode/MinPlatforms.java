package leetcode;

import java.util.*;

/*
------------------------------------------------------------------------------------

You are given two arrays: one contains the arrival time of trains 
and the other contains the departure time of trains at a railway station.

Your task is to calculate the **minimum number of platforms required** so that
**no train has to wait**, meaning at arrival time a platform must be free.

RULE:
If a train arrives at the same time or before another train departs, 
then an **extra platform is required**.

Example:
arr = {900, 945, 955, 1100, 1500, 1800}
dep = {920, 1200, 1130, 1150, 1900, 2000}

At 11:00 → 3 trains are present (900–920, 945–1200, 955–1130, 1100 arrives)
Therefore answer = 3 platforms.

------------------------------------------------------------------------------------
*/

public class MinPlatforms {

    public static int minPlatform(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0, j = 0;
        int platforms = 0, maxPlatforms = 0;

        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                platforms++;
                i++;
            } else {
                platforms--;
                j++;
            }
            maxPlatforms = Math.max(maxPlatforms, platforms);
        }
        return maxPlatforms;
    }

    public static void main(String[] args) {

        int[] arrival = {900, 945, 955, 1100, 1500, 1800};
        int[] departure = {920, 1200, 1130, 1150, 1900, 2000};

        System.out.println("Arrival Times   : " + Arrays.toString(arrival));
        System.out.println("Departure Times : " + Arrays.toString(departure));

        int result = minPlatform(arrival, departure);
        System.out.println("\nMinimum Platforms Required = " + result);
    }
}
