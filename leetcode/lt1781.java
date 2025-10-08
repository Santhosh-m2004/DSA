package leetcode;

public class lt1781 {
    public int beautySum(String s) {
        int n = s.length();
        int totalBeauty = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;

                for (int f : freq) {
                    if (f > 0) {
                        maxFreq = Math.max(maxFreq, f);
                        minFreq = Math.min(minFreq, f);
                    }
                }

                totalBeauty += maxFreq - minFreq;
            }
        }

        return totalBeauty;
    }

    public static void main(String[] args) {
        lt1781 obj = new lt1781();

        String s1 = "aabcb";
        System.out.println("Beauty sum of \"" + s1 + "\" = " + obj.beautySum(s1)); // 5

        String s2 = "abc";
        System.out.println("Beauty sum of \"" + s2 + "\" = " + obj.beautySum(s2)); // 0

        String s3 = "aaa";
        System.out.println("Beauty sum of \"" + s3 + "\" = " + obj.beautySum(s3)); // 0

    }
}

