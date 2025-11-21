package leetcode;
import java.util.*;

class jobSequencingProblem {

    class Node {
        int id;
        int dl;
        int pro;

        Node(int id, int dl, int pro) {
            this.id = id;
            this.dl = dl;
            this.pro = pro;
        }
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

        int n = deadline.length;
        Node[] arr = new Node[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Node(i + 1, deadline[i], profit[i]);
        }

        Arrays.sort(arr, (a, b) -> b.pro - a.pro);

        int maxDeadline = 0;
        for (Node job : arr) {
            maxDeadline = Math.max(maxDeadline, job.dl);
        }

        int[] fq = new int[maxDeadline + 1];
        Arrays.fill(fq, -1);

        int cnt = 0;
        int total = 0;

        for (Node job : arr) {
            for (int j = job.dl; j > 0; j--) {
                if (fq[j] == -1) {
                    fq[j] = job.id;
                    cnt++;
                    total += job.pro;
                    break;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(cnt);
        result.add(total);
        return result;
    }

    public static void main(String[] args) {
        jobSequencingProblem s = new jobSequencingProblem();
        int[] deadline = {2, 1, 2, 1, 3};
        int[] profit = {100, 19, 27, 25, 15};
        System.out.println(s.jobSequencing(deadline, profit));
    }
}
