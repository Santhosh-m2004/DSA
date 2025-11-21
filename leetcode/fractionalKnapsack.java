package leetcode;
import java.util.*;

public class fractionalKnapsack {

    static class Node {
        int val;
        int wt;
        double one;
        Node(int val, int wt, double one) {
            this.val = val;
            this.wt = wt;
            this.one = one;
        }
    }

    public double fractionalKnapsack1(int[] val, int[] wt, int capacity) {
        int n = wt.length;
        Node[] arr = new Node[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Node(val[i], wt[i], (double) val[i] / wt[i]);
        }

        Arrays.sort(arr, (a, b) -> Double.compare(b.one, a.one));

        double total = 0;
        int cap = 0;

        for (int i = 0; i < n; i++) {
            if (cap + arr[i].wt <= capacity) {
                total += arr[i].val;
                cap += arr[i].wt;
            } else {
                int rem = capacity - cap;
                total += rem * arr[i].one;
                break;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        fractionalKnapsack s = new fractionalKnapsack();

        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int capacity = 50;

        System.out.println(s.fractionalKnapsack1(val, wt, capacity));
    }
}
