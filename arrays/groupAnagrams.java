import java.util.*;

class groupAnagrams {
    public List<List<String>> groupAnagram(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();

        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sortedArray = new String(ch);
            mp.putIfAbsent(sortedArray, new ArrayList<>());
            mp.get(sortedArray).add(str);
        }
        return new ArrayList<>(mp.values());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input in the format [[word1][word2]...] :");
        String input = scanner.nextLine();
        scanner.close();

        // Processing input: Removing brackets and splitting words
        input = input.replaceAll("[\\[\\]]", " ").trim(); // Remove square brackets
        String[] words = input.split(",\s*"); // Split by spaces

        groupAnagrams solution = new groupAnagrams();
        List<List<String>> result = solution.groupAnagram(words);

        System.out.println("Grouped Anagrams:");
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
