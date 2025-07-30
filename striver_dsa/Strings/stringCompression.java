package Strings;

import java.util.*;

public class stringCompression {

    // Not in-place version using StringBuilder
    public static char[] res(char[] chars) {
        StringBuilder sb = new StringBuilder();
        char prev = chars[0];
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == prev) {
                count++;
            } else {
                sb.append(prev);
                if (count > 1) {
                    for (char c : String.valueOf(count).toCharArray()) {
                        sb.append(c);
                    }
                }
                prev = chars[i];
                count = 1;
            }
        }

        sb.append(prev);
        if (count > 1) {
            for (char c : String.valueOf(count).toCharArray()) {
                sb.append(c);
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }

        System.out.println("Length from StringBuilder: " + sb.length());
        return sb.toString().toCharArray();
    }

    // Optimal in-place compression 
    public static int compress(char[] chars) {
        int i = 0;
        int j = 0;

        while (j < chars.length) {
            char prev = chars[j];
            int count = 0;

            while (j < chars.length && chars[j] == prev) {
                count++;
                j++;
            }

            chars[i++] = prev;

            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[i++] = c;
                }
            }
        }

        return i;
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c'};

        // Not in-place
        System.out.println("Result from StringBuilder: " + Arrays.toString(res(chars)));
        

        // // In-place
        // int idx = compress(chars);
        // System.out.print("In-place Compressed: ");
        // for (int i = 0; i < idx; i++) {
        //     System.out.print(chars[i] + " ");
        // }
        // System.out.println("\nLength after compression: " + idx);
    }
}
