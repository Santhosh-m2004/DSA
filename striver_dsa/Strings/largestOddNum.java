package Strings;

public class largestOddNum {
    static String res(String num){
        int index = -1;
        for (int i = num.length() - 1; i >= 0; i--) {
            int ch = num.charAt(i) - '0'; 
            if (ch % 2 != 0) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return "";
        } else {
            return num.substring(0, index + 1);
        }
    }
    public static void main(String[] args) {
        String str="234045";
        System.out.println(res(str));
    }
}
