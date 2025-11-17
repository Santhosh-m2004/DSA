package leetcode;

/**
 * Problem: Lemonade Change (LeetCode 860)
 *
 * You run a lemonade stand where lemonade costs $5.
 * Customers pay in the order given using bills of 5, 10, or 20.
 * You must give correct change using the money collected so far.
 *
 * Rules for giving change:
 * - If bill = 5  → no change needed
 * - If bill = 10 → must give one $5
 * - If bill = 20 → prefer giving $10 + $5, otherwise give three $5
 *
 * Return true if correct change can be given to all customers, else false.
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 */

import java.util.*;

public class lt860 {

    public static boolean lemonadeChange(int[] bills) {
        int count5 = 0, count10 = 0;

        for (int bill : bills) {
            if (bill == 5) {
                count5++;
            } 
            else if (bill == 10) {
                if (count5 == 0) return false;
                count5--;
                count10++;
            } 
            else { 
                if (count10 > 0 && count5 > 0) {
                    count10--;
                    count5--;
                } else if (count5 >= 3) {
                    count5 -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] bills = {5, 5, 5, 10, 20};

        System.out.println(lemonadeChange(bills));
    }
}

