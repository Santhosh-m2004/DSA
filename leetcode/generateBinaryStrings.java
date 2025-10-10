package leetcode;
import java.util.*;
public class generateBinaryStrings {

    public static List<String> generate(int n){
        List<String> res=new ArrayList<>();
        String str="";
        recursion(n,res,str);
        return res;
    } 
    public static void recursion(int n,List<String> res,String str){
        if(str.length()==n){
            res.add(str);
            return;
        }
        recursion(n,res,str+'0');
        if(str.isEmpty()|| str.charAt(str.length()-1)!='1'){
            recursion(n,res,str+'1');
        }
    }
    public static void main(String[] args) {
        int n=3;
        System.out.println(generate(n));
    }
}
