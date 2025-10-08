package leetcode;
/*Problem Statement: You are given a string s and a positive integer k.
Return the number of substrings that contain exactly k distinct characters.
Example 1:  
Input: s = "pqpqs", k = 2  
Output: 7  
Explanation:  All substrings with exactly 2 distinct characters:  
"pq", "pqp", "pqpq", "qp", "qpq", "pqs", "qs"  
Total = 7. */
import java.util.HashMap;

public class countNumberOfSubStrings {

    public static int atMostKDistinct(String s,int k){
        int res=0;
        int left=0;
        HashMap<Character,Integer> map=new HashMap<>();

        for(int right=0;right<s.length();right++){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right), 0)+1);

            while(map.size()>k){
                char leftChar=s.charAt(left);
                map.put(leftChar,map.get(leftChar)-1);
                if(map.get(leftChar)==0){
                    map.remove(leftChar);
                }
                left++;
            }
            res+=right-left+1;
        }
        return res;
    }

    public static int countSubstrings(String s, int k) {
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }
    public static void main(String[] args) {
        // Sample test
        String s = "pqpqs";
        int k = 2;

        // Output the result
        System.out.println("Count: " + countSubstrings(s, k)); // Output: 7
    }
}
