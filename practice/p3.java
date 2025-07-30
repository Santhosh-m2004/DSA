package practice;

import java.util.HashMap;

//longest subarray with sum k
public class p3 {
    public static int res(int[] arr,int k){
        int n=arr.length;
        int sum=0;
        int maxLen=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==k){
                maxLen=Math.max(maxLen,i+1);
            }
            int rem=k-sum;
            if(map.containsKey(rem)){
                maxLen=Math.max(maxLen,i-map.get(rem));
            }
            if(!map.containsKey(rem)){
                map.put(sum, i+1);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr={2,3,0,0,5,1,9};
        int k=10;
        System.out.println(res(arr, k));
    }
}
