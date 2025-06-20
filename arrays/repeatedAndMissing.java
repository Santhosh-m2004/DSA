package arrays;

import java.util.*;

public class repeatedAndMissing {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int[] repeatedNumber(final int[] A) {
        HashSet<Integer> set = new HashSet<>();
        int n = A.length;
        int repeated = -1, missing = -1;
        
        // Step 1: Find the repeated number
        for (int num : A) {
            if (set.contains(num)) {
                repeated = num;  // Found the repeated number
            } else {
                set.add(num);
            }
        }

        // Step 2: Find the missing number
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }

        return new int[]{repeated, missing};
    }
    public static void main(String[] args) {
        int[] A={3,1,2,5,3};
        System.out.println(Arrays.toString(repeatedNumber(A)));
    }
}

