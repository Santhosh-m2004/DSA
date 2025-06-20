import java.util.Arrays;

public class longestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        Arrays.sort(strs);
        String first=strs[0];
        String last=strs[strs.length-1];
        int ans=0;
        for(int i=0;i<Math.min(first.length(),last.length());i++){
            if(first.charAt(i)==last.charAt(i)){
                ans++;
            }else{
                break;
            }
        }
        return first.substring(0,ans);
    }

    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
