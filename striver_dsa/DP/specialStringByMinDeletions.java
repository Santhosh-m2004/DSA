package DP;
import java.util.*;
/*We are given a string word and an integer k.
We need to make the difference between max and min frequency of characters ≤ k, by deleting minimum characters */
public class specialStringByMinDeletions {
    public static void main(String[] args) {
        String word = "aabcaba";
        int k = 0;
        int[] fq=new int[26];
        for(char c:word.toCharArray()){
            fq[c-'a']++;
        }

        int count=0;
        for(int i:fq){
            if(i>0){
                count++;
            }
        }
        int[] fq2=new int[count];
        int idx=0;
        for(int i:fq){
            if(i>0){
                fq2[idx++]=i;
            }
        }

        Arrays.sort(fq2);
        int n = fq2.length;
        int[][] dp = new int[n][n];

        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                if(fq2[j]-fq2[i]<=k){
                    dp[i][j]=0;
                }
                else{
                    int leftdelete=fq2[i]+dp[i+1][j];
                    int rightdelete=fq2[j]-(fq2[i]+k)+dp[i][j-1];
                    dp[i][j]=Math.min(leftdelete,rightdelete);
                }
            }
        }
        System.out.print(dp[0][n-1]);
    }
}
