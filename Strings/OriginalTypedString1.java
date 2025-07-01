package Strings;
public class OriginalTypedString1 {
    public static int possibleStringCount(String word) {
        int count=word.length();
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)!=word.charAt(i-1)){
                count--;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s="aabbcccc";
        System.out.println(possibleStringCount(s));
    }
}
