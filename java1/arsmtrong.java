package java1;
import java.util.*;

public class arsmtrong {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the number");
        int num=s.nextInt();
        s.close();
        if(isArmstrong(num)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

    public static boolean isArmstrong(int num){
        String str=String.valueOf(num);
        char[] ch=str.toCharArray();
        int sum=0;
        for(char c:ch){
            int digit=c-'0';
            sum=sum+(int)Math.pow(digit,str.length());
        }

        return sum==num;
    }
}
