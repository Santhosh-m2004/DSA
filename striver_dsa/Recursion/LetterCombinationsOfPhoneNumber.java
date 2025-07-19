package Recursion;
import java.util.*;
/*Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. 
Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:
Input: digits = ""
Output: []
Example 3:
Input: digits = "2"
Output: ["a","b","c"] */
public class LetterCombinationsOfPhoneNumber {
    public static List<String> ph(String digits){
        List<String> res=new ArrayList<>();
        if(digits==null || digits.length()==0){
            return res;
        }
        String[] map=new String[10];
        map[2] = "abc"; map[3] = "def"; map[4] = "ghi";
        map[5] = "jkl"; map[6] = "mno"; map[7] = "pqrs";
        map[8] = "tuv"; map[9] = "wxyz";
        StringBuilder sb=new StringBuilder();
        recursion(digits, 0, map, res, sb);
        return res;
    }
    public static void recursion(String digits,int idx,String[] map,List<String> res,StringBuilder sb){
        if(idx==digits.length()){
            res.add(sb.toString());
            return;
        }
        int digit=digits.charAt(idx)-'0';
        String letters=map[digit];
        for(int i=0;i<letters.length();i++){
            sb.append(letters.charAt(i));
            recursion(digits, idx+1, map, res, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args) {
        String digits = "22";
        System.out.println(ph(digits));
    }
}
