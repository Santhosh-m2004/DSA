package leetcode;

import java.util.*;

public class lt904 {
    public static void main(String[] args) {
        int[] fruits = {1, 2, 1, 2, 3, 2, 2, 1};
        System.out.println(new lt904().totalFruit(fruits));
    }

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;

        while (right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            right++;

            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }

            max = Math.max(max, right - left);
        }

        return max;
    }
}

