package Strings;

import java.util.*;

public class groupAnagram{
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);

        // Example input to test
        // String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String str=s.nextLine();
        String str1[]=str.split(",");
        
        // Call the groupAnagrams method
        List<List<String>> result = groupAnagrams(str1);
        
        // Print the result
        System.out.println(result);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        // Map to store sorted word as key and list of anagrams as value
        Map<String, List<String>> anagramGroups = new HashMap<>();

        // Process each word
        for (String str : strs) {
            // Sort characters to create key
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // Add to map: if key doesn't exist, create empty list first
            anagramGroups.putIfAbsent(sortedStr, new ArrayList<>());

            // Add the word to the correct anagram group
            anagramGroups.get(sortedStr).add(str);
        }

        // Return all anagram groups as a list of lists
        return new ArrayList<>(anagramGroups.values());
    }
}

