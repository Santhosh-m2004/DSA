package Array;

import java.util.*;

public class FindLuckyInteger {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 4}; 
        Solution sol = new Solution();
        System.out.println("Lucky Integer: " + sol.findLucky(arr));
    }
}

class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501];
        for (int num : arr) {
            freq[num]++;
        }

        for (int i = 500; i >= 1; i--) {
            if (freq[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
