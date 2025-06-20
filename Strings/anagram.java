package Strings;
import java.util.*;
public class anagram {

    public static void main(String[] args){
        String s="mana";
        String t="aamn";
        anagram obj=new anagram();
        System.out.println(obj.isAnagram(s, t));
    }
    public boolean isAnagram(String s, String t) {
        
        
        char a1[]=s.toCharArray();
        char a2[]=t.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
       
        return Arrays.equals(a1,a2);
    }
}
