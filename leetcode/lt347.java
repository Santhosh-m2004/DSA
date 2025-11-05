package leetcode;
import java.util.*;

public class lt347 {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int[] ans=new int[k];
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());

        pq.addAll(map.entrySet());
        for(int i=0;i<k;i++){
            Map.Entry<Integer,Integer> m=pq.poll();
            ans[i]=m.getKey();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3}; 
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
