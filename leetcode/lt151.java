package leetcode;

public class lt151 {
    public static String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        for (int i = 0; i < words.length / 2; i++) {
            String temp = words[i];
            words[i] = words[words.length - 1 - i];
            words[words.length - 1 - i] = temp;
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        String[] testCases = {
            "   the   sky   is  blue  ",
            "hello world",
            "  java   is  fun ",
            "a good   example",
            "   one"
        };

        for (String input : testCases) {
            System.out.println("Input: \"" + input + "\"");
            System.out.println("Output: \"" + reverseWords(input) + "\"");
            System.out.println();
        }
    }
}
