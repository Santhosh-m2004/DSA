package Strings;
import java.util.*;
/*Given a string s, sort it in decreasing order based on the frequency of the characters. 
The frequency of a character is the number of times it appears in the string.
Return the sorted string. If there are multiple answers, return any of them. */
public class SortCharByFq {
    static String res(String s){
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        Character[] arr=new Character[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i]=s.charAt(i);
        }
        Arrays.sort(arr,(a,b)->{
            int fqA=map.get(a);
            int fqB=map.get(b);
            if(fqA!=fqB){
                return fqB-fqA;
            }else{
                return a-b;
            }
        });

        StringBuilder sb=new StringBuilder();
        for(char c:arr){
            sb.append(c);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s="loveleetcode";
        System.out.println(res(s));
    }
}
