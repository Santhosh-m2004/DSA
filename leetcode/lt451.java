package leetcode;
import java.util.*;

public class lt451 {
    public String frequencySort(String s) {
        int n = s.length();
        int[] fq = new int[128];

        for (int i = 0; i < n; i++) {
            fq[s.charAt(i)]++;
        }

        int[][] arr = new int[128][2];
        for (int i = 0; i < 128; i++) {
            arr[i][0] = i;         
            arr[i][1] = fq[i]; 
        }

        Arrays.sort(arr, (a, b) -> b[1] - a[1]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            int freq = arr[i][1];
            char c = (char) arr[i][0];
            for (int j = 0; j < freq; j++) {
                sb.append(c);
            }
        }
        /*
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            int freq = arr[i][1];
            if (freq > 0) {
                sb.append(String.valueOf((char) arr[i][0]).repeat(freq));
            }
        }
         */

        return sb.toString();
    }

    public static void main(String[] args) {
        lt451 obj = new lt451();

        String s1 = "tree";
        System.out.println(obj.frequencySort(s1)); // eetr or eert

        String s2 = "cccaaa";
        System.out.println(obj.frequencySort(s2)); // aaaccc or cccaaa

        String s3 = "Aabb";
        System.out.println(obj.frequencySort(s3)); // bbAa or bbaA
    }
}

