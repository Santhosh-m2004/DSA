package leetcode;
import java.util.*;
class lt17 {
    public static List<String> letterCombinations(String digits) {
        String[] map=new String[10];
        map[2]="abc";
        map[3]="def";
        map[4]="ghi";
        map[5]="jkl";
        map[6]="mno";
        map[7]="pqrs";
        map[8]="tuv";
        map[9]="wxyz";
        List<String> lst=new ArrayList<>();
        backtrack(0,digits,map,new StringBuilder(),lst);
        return lst;
    }

    public static void backtrack(int idx,String digits,String[] map,StringBuilder sb,List<String> lst){
        if(idx==digits.length()){
            lst.add(sb.toString());
            return;
        }
        int digit=digits.charAt(idx)-'0';
        String val=map[digit];

        for(int i=0;i<val.length();i++){
            sb.append(val.charAt(i));
            backtrack(idx+1,digits,map,sb,lst);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}