package Recursion;

import java.util.Arrays;

public class reverseArray {
    public static int[] reverse(int[] arr,int i,int j){
        if(i==j){
            return arr;
        }
        swap(arr,i,j);
        return reverse(arr,i+1,j-1);
    }
    public static void swap(int[] arr,int left,int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        System.out.println(Arrays.toString(reverse(arr,0,arr.length-1)));
    }
}
