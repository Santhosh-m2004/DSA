package Strings;

class removeConsecutiveCharacter {
    public static String removeConsecutiveCharacter(String s) {
        StringBuilder res = new StringBuilder(); // Use StringBuilder for efficiency
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                continue;
            } else {
                res.append(s.charAt(i)); // Append to StringBuilder
            }
        }
        return res.toString(); // Convert StringBuilder to String
    }

    public static void main(String[] args) {
        String s="aabbcc";
        
        System.out.println(removeConsecutiveCharacter(s)); 
        
    }
}

