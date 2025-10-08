package leetcode;

public class lt12 {
    public String intToRoman(int num) {
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values =    {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        lt12 obj = new lt12();

        System.out.println("3 -> " + obj.intToRoman(3));       // III
        System.out.println("4 -> " + obj.intToRoman(4));       // IV
        System.out.println("9 -> " + obj.intToRoman(9));       // IX
        System.out.println("58 -> " + obj.intToRoman(58));     // LVIII
        System.out.println("1994 -> " + obj.intToRoman(1994)); // MCMXCIV
    }
}
