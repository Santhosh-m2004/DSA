package Strings;
/*Given a string word, compress it using the following algorithm:
Begin with an empty string comp. While word is not empty, use the following operation:
Remove a maximum length prefix of word made of a single character c repeating at most 9 times.
Append the length of the prefix followed by c to comp.
Return the string comp.

Input: word = "abcde"
Output: "1a1b1c1d1e"

Input: word = "aaaaaaaaaaaaaabb"
Output: "9a5a2b" 
*/
public class stringCompression3 {
    public static String compressedString(String word) {
        StringBuilder sb=new StringBuilder();
        int i=0;
        int j=0;
        while(j<word.length()){
            char prev=word.charAt(j);
            int count=0;
            while(j<word.length() && word.charAt(j)==prev && count<9){
                j++;
                count++;
            }
            sb.append(count);
            sb.append(prev);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String word = "aaaaaaaaaaaaaabb";
        System.out.println(compressedString(word));
    }
}
