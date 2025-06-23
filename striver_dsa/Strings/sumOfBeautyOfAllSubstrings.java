package Strings;
import java.util.*;
// O(n^3)
class sumOfBeautyOfAllSubstrings {
    public static  int beautySum(String s) {
        int n=s.length();
        int len=0;  

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int[] arr=new int[26];
                for (int k = i; k <= j; k++) {
                    arr[s.charAt(k) - 'a']++;
                }

                Arrays.sort(arr);
                int zIdx=0;
                for(int m=0;m<26;m++){
                    if(arr[m]!=0){
                        zIdx=m;
                        break;
                    }
                }
                len+=arr[25]-arr[zIdx];

            }
        }
        return len;
    }
    public static void main(String[] args) {
        String s="aabcbaa";
        System.out.println(beautySum(s));
    }
}

//O(n^2)

/*package Strings;
import java.util.*;

class sumOfBeautyOfAllSubstrings {
    public static  int beautySum(String s) {
        int n = s.length();
        int totalBeauty = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;

                for (int f : freq) {
                    if (f > 0) {
                        maxFreq = Math.max(maxFreq, f);
                        minFreq = Math.min(minFreq, f);
                    }
                }

                totalBeauty += maxFreq - minFreq;
            }
        }

        return totalBeauty;
    }
    public static void main(String[] args) {
        String s="aabcbaa";
        System.out.println(beautySum(s));
    }
}
 */