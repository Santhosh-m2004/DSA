package leetcode;

public class lt424 {
    public int characterReplacement(String s, int k) {
        int max = 0;
        for (int i = 'A'; i <= 'Z'; i++) {
            char ch = (char) i;
            
            int nonCount = 0;
            int left = 0;
            int right = 0;

            while (right < s.length()) {
                if (s.charAt(right) != ch) {
                    nonCount++;
                }
                right++;

                while (nonCount > k) {
                    if (s.charAt(left) != ch) {
                        nonCount--;
                    }
                    left++;
                }

                max = Math.max(max, right - left);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(new lt424().characterReplacement(s, k));
    }
}
