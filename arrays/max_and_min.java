package arrays;
import java.util.*;

public class max_and_min{
    public static void main(String[] args){
           Scanner s=new Scanner(System.in);
           int[] arr=new int[5];
           for(int i=0;i<5;i++){
            arr[i]=s.nextInt();
           }

        int min=arr[0];
        int max=arr[0];
        
        for(int i=1;i<arr.length;i++){
            if(arr[i]<min) min=arr[i];
            if(arr[i]>max) max=arr[i];
        }
        
        System.out.println(min+" "+max);

    }
}