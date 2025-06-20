import java.util.*;

/*
 * This program sorts the characters in a given string
 * based on the frequency of each character in descending order.
 * If two characters have the same frequency, they are sorted by their ASCII value.
 * 
 * Time Complexity: O(n log n) where n is the length of the string
 * Space Complexity: O(n)
 */

class fq_sort {
    public static String frequencySort(String s) {
        // Step 1: Create a frequency array for ASCII characters (0 to 127)
        int[] fq = new int[128];
        for (int i = 0; i < s.length(); i++) {
            fq[s.charAt(i)]++; // Increment frequency of each character
        }

        // Step 2: Convert the input string to a Character[] array
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }

        // Step 3: Sort the characters based on frequency (descending)
        // If frequencies are equal, sort by character value (ascending)
        Arrays.sort(chars, (a, b) -> {
            if (fq[b] != fq[a]) {
                return fq[b] - fq[a]; // Higher frequency first
            } else {
                return a - b; // Lexicographical order if same frequency
            }
        });

        // Step 4: Build the final sorted string
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "cccaaa";
        System.out.println(frequencySort(s)); // Output: "cccaaa" or "aaaccc"
    }
}
