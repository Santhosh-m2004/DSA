package leetcode;

public class lt125 {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        return isPal(sb.toString());
    }

    public static boolean isPal(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        lt125 sol = new lt125();
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = " ";
        System.out.println(sol.isPalindrome(s1)); // true
        System.out.println(sol.isPalindrome(s2)); // false
        System.out.println(sol.isPalindrome(s3)); // true
    }
}
