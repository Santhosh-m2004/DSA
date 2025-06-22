package Strings;
import java.io.StringWriter;
import java.util.*;
/*Given a string s, divide it into groups of size k.
Each group contains exactly k characters — if the last group has fewer than k, 
    fill it with the character fill.
Return an array of all the groups.
After removing the fill characters from the last group (if any) and joining all groups, 
    the result should match the original string s. */
public class divideStringIntoKGroup {
    static String[] res(String s,int k,char fill){
        int n=s.length();
        int size=(n+k-1)/k;
        String[] arr=new String[size];
        int start=0;
        int end=start+k;
        for(int i=0;i<arr.length;i++){
            if(end<=s.length()){
                arr[i]=s.substring(start, end);
            }else{
                String temp=s.substring(start);
                while(temp.length()<k){
                    temp+=fill;
                }
                arr[i]=temp;
            }
            start=start+k;
            end=end+start;
        }
        return arr;
    }
    public static void main(String[] args) {
        String s="abcdefghij";
        int k = 3;
        char fill = 'x';
        System.out.println(Arrays.toString(res(s,k,fill)));
    }
}
