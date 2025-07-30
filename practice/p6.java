package practice;

import java.util.Arrays;

public class p6 {
    public static int[] res(int[] arr){
        int n=arr.length;
        int idx=-1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                idx=i ;
                break;
            }
        }

        if(idx==-1){
            int start=0;
            int end=n-1;
            while(start<end){
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }
        }else{
            for(int i=n-1;i>=idx;i--){
                if(arr[i]>idx){
                    int temp=arr[i];
                    arr[i]=arr[idx];
                    arr[idx]=temp;
                    break;
                }
            }
        }
        Arrays.sort(arr,idx+1,n);
        return arr;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3};
        System.out.println(Arrays.toString(res(arr)));
    }
}
