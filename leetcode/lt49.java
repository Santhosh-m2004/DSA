package leetcode;
import java.util.*;

import Strings.groupAnagram;
class lt49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>  mp=new HashMap<>();

        for(String str:strs){
            char[] ch=str.toCharArray();
            Arrays.sort(ch);
            String sortedArray=new String(ch);
            mp.putIfAbsent(sortedArray,new ArrayList<>());
            mp.get(sortedArray).add(str);

        }
        return new ArrayList<>(mp.values());
    }

    public static void main(String[] args) {
        String[]  strs = {"eat","tea","tan","ate","nat","bat"};
        lt49 res=new lt49();
        System.out.println(res.groupAnagrams(strs));
    }
}
