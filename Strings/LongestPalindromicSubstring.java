package Strings;


class LongestPalindromicSubstring {
    public static String LongestPalindrome(String s) {
        int n=s.length();
        if (s == null || s.length() < 1) return "";
        int start=0,maxLength=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s,i,j) && j-i+1>maxLength){
                    start=i;
                    maxLength=j-i+1;
                }
            }
        }
        return s.substring(start,start+maxLength);
    }

    public static boolean isPalindrome(String s,int left,int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s="tgvjhbmnabbabbaohnj";
        System.out.println(LongestPalindrome(s));
    }
}
