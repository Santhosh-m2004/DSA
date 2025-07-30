package practice;

import java.util.Arrays;
import java.util.Scanner;


public class p2 {
    public static int[] res(int[] arr,int k){
        int n=arr.length;
        swap(arr,0,n-k-1);
        swap(arr,n-k,n-1);
        swap(arr,0,n-1);
        return arr;
    }
    public static void swap(int[] arr,int start,int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine().replace("[", " ").replace("]", " ").trim();
        int k=sc.nextInt();
        String[] str=s.split("\\s+");

        int[] arr=new int[str.length];
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.parseInt(str[i]);
        }

        System.out.println(Arrays.toString(res(arr,k)));

    }
}
