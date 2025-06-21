package Strings;
import java.util.*;
public class IsomorphicStrings {
    static boolean res(String s,String t){
        int len1=s.length();
        int len2=t.length();
        int[] arr1=new int[26];
        int[] arr2=new int[26];
        if(len1!=len2){
            return false;
        }

        for(int i=0;i<len1;i++){
            if(arr1[s.charAt(i)-'a']!=arr2[s.charAt(i)-'a']){
                return false;
            }
            arr1[s.charAt(i)-'a']++;
            arr2[s.charAt(i)-'a']++;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(res(s,t));
    }
}
