package Strings;
import java.util.*;

class shuffleString {
    public String restoreString(String s, int[] indices) {
        StringBuilder sb1=new StringBuilder();
        HashMap<Integer,Character> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(indices[i],s.charAt(i));
        }
        for(int i=0;i<s.length();i++){
            sb1.append(map.get(i));
        }
        return sb1.toString();
        // char[] arr=new char[indices.length];
        // for(int i=0;i<indices.length;i++){
        //     arr[indices[i]]=s.charAt(i);
        // }
        // return new String(arr);
    }
    public static void main(String[] args) {
        String s="aiohn";
        int[] indices={3,1,4,2,0};
        shuffleString obj=new shuffleString();
        System.out.println(obj.restoreString(s, indices));
    }

}