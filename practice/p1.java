package practice;
import java.util.*;
//Second largest ele in an array without sorting
public class p1 {
    public static int res(int[] arr){
        int large=Integer.MIN_VALUE;
        int secLarge=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>large){
                secLarge=large;
                large=arr[i];
            }else if(arr[i]>secLarge && arr[i]!=large){
                secLarge=arr[i];
            }
        }
        return secLarge;
    }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();            
        String[] str = s.split("\\s+");         
        int[] arr = new int[str.length];

        for (int i = 0; i < str.length; i++) {    
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(res(arr));

    }
}
