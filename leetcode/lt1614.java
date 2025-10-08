package leetcode;

public class lt1614 {
    public int maxDepth(String s) {
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
                maxCount = Math.max(count, maxCount);
            } else if (s.charAt(i) == ')') {
                count--;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        lt1614 obj = new lt1614();

        String s1 = "(1+(2*3)+((8)/4))+1";
        System.out.println("Max Depth of \"" + s1 + "\" = " + obj.maxDepth(s1)); // 3

        String s2 = "(1)+((2))+(((3)))";
        System.out.println("Max Depth of \"" + s2 + "\" = " + obj.maxDepth(s2)); // 3

        String s3 = "1+(2*3)/(2-1)";
        System.out.println("Max Depth of \"" + s3 + "\" = " + obj.maxDepth(s3)); // 1

        String s4 = "1";
        System.out.println("Max Depth of \"" + s4 + "\" = " + obj.maxDepth(s4)); // 0
    }
}
