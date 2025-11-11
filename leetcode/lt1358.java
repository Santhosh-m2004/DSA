package leetcode;

public class lt1358 {
    public int numberOfSubstrings(String s) {
        int[] arr = new int[3]; 
        int left = 0;
        int right = 0;
        int count = 0;

        while (right < s.length()) {
            arr[s.charAt(right) - 'a']++;

            while (arr[0] > 0 && arr[1] > 0 && arr[2] > 0) {
                // every substring starting from 'left' and ending from 'right' to end is valid
                count += s.length() - right;

                arr[s.charAt(left) - 'a']--;
                left++;
            }

            right++;
        }

        return count;
    }

    public static void main(String[] args) {
        lt1358 sol = new lt1358();
        String s = "abcabc";
        System.out.println(sol.numberOfSubstrings(s)); // Expected output: 10
    }
}

