package practice;

import java.util.Arrays;
import java.util.HashMap;

public class p4 {
    public static int[] res(int[] arr,int tar){
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(tar-arr[i])){
                return new int[]{i,map.get(tar-arr[i])};
            }
            else{
                map.put(arr[i],i);
            }
        }
        return new int[]{};
            
    }
    public static void main(String[] args) {
        int[] arr={3,2,4};
        int k=10;
        System.out.println(Arrays.toString(res(arr, k)));
    }
}
