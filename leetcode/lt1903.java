package leetcode;

public class lt1903 {
    public String largestOddNumber(String num) {
        int idx = -1;
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 != 0) {
                idx = i;
                break;
            }
        }
        return idx == -1 ? "" : num.substring(0, idx + 1);
    }

    public static void main(String[] args) {
        lt1903 obj = new lt1903();

        String num1 = "35427";
        System.out.println("Largest Odd Number in " + num1 + " = " + obj.largestOddNumber(num1));

        String num2 = "4206";
        System.out.println("Largest Odd Number in " + num2 + " = " + obj.largestOddNumber(num2));

        String num3 = "52";
        System.out.println("Largest Odd Number in " + num3 + " = " + obj.largestOddNumber(num3));
    }
}
