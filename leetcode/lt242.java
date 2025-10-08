package leetcode;

public class lt242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] arr1 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr1[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (arr1[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        lt242 obj = new lt242();

        System.out.println(obj.isAnagram("anagram", "nagaram")); // true
        System.out.println(obj.isAnagram("rat", "car")); // false
        System.out.println(obj.isAnagram("listen", "silent")); // true
        System.out.println(obj.isAnagram("hello", "bello")); // false
    }
}
