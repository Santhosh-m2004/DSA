package Strings;
import java.util.*;
public class longestCommonPrefix {
    static String res(String[] str){
        Arrays.sort(str);
        String start=str[0];
        String last=str[str.length-1];
        int count=0;
        for(int i=0;i<Math.min(start.length(),last.length());i++){
            if(start.charAt(i)==last.charAt(i)){
                count++;
            }else{
                break;
            }
        }
        return start.substring(0, count);

    }
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(res(strs));
    }
}
