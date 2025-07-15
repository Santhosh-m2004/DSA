package Strings;

public class CheckWordValidity {
    public static boolean isValid(String word) {
        if (word.length() < 3) return false;

        boolean hasVowel = false, hasConsonant = false;

        for (char c : word.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) return false;

            if (Character.isLetter(c)) {
                char lower = Character.toLowerCase(c);
                if ("aeiou".indexOf(lower) != -1) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }
        }

        return hasVowel && hasConsonant;
    }

    public static void main(String[] args) {
        String[] testWords = {"abc123", "aei", "123", "ab", "a1b"};

        for (String word : testWords) {
            System.out.println("Word: " + word + " -> " + (isValid(word) ? "Valid" : "Invalid"));
        }
    }
}
