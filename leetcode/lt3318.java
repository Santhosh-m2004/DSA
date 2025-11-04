package leetcode;
import java.util.*;

class lt3318 {
    public static int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        ans[0] = topXSum(map, x);

        for (int i = k; i < n; i++) {
            int out = nums[i - k];
            int in = nums[i];

            map.put(out, map.getOrDefault(out, 0) - 1);
            if (map.get(out) == 0) map.remove(out);

            map.put(in, map.getOrDefault(in, 0) + 1);

            ans[i - k + 1] = topXSum(map, x);
        }

        return ans;
    }

    public static int topXSum(Map<Integer, Integer> map, int x) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
            new PriorityQueue<>((a, b) -> {
                if (!b.getValue().equals(a.getValue()))
                    return b.getValue() - a.getValue();
                else
                    return b.getKey() - a.getKey();
            });

        pq.addAll(map.entrySet());

        int sum = 0;
        for (int i = 0; i < x && !pq.isEmpty(); i++) {
            Map.Entry<Integer, Integer> e = pq.poll();
            sum += e.getKey() * e.getValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4,2,3};
        int k = 6;
        int x = 2;
        
        System.out.println(Arrays.toString(findXSum(nums, k, x)));

        int[] nums2 = {3,8,7,8,7,5};
        int k2 = 2;
        int x2 = 2;
        System.out.println(Arrays.toString(findXSum(nums2, k2, x2)));
    }
}
