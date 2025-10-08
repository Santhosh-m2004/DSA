package leetcode;

public class lt13 {
    public int romanToInt(String s) {
        int[] values = new int[128];
        values['I'] = 1;
        values['V'] = 5;
        values['X'] = 10;
        values['L'] = 50;
        values['C'] = 100;
        values['D'] = 500;
        values['M'] = 1000;

        int ans = 0;
        int prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = values[s.charAt(i)];
            if (cur < prev) {
                ans -= cur;
            } else {
                ans += cur;
            }
            prev = cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        lt13 obj = new lt13();

        System.out.println("III -> " + obj.romanToInt("III"));       // 3
        System.out.println("IV -> " + obj.romanToInt("IV"));         // 4
        System.out.println("IX -> " + obj.romanToInt("IX"));         // 9
        System.out.println("LVIII -> " + obj.romanToInt("LVIII"));   // 58
        System.out.println("MCMXCIV -> " + obj.romanToInt("MCMXCIV"));// 1994
    }
}
