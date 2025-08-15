package Array;
import java.util.Arrays;

// Sort an array according to count of prime digits of elements in array
//input: nums={121,111,333};
//output: {111,121,333}
public class primeSort {

    public static int[] sort(int[] nums){
        int[][] arr=new int[nums.length][2];
        int n=nums.length;
        int i=0;
        for(int num:nums){
            arr[i][0]=num;
            int count=0;
            while(num!=0){
                int digit=num%10;
                if(isPrime(digit)) count++;
                num/=10;
            }
            arr[i][1]=count;
            i++;
        }

        Arrays.sort(arr,(a,b)-> a[1]-b[1]);
        int[] res=new int[nums.length];
        for(int j=0;j<nums.length;j++){
            res[j]=arr[j][0];
        }
        return res;
    }

    public static boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums={121,111,333};
        System.out.println(Arrays.toString(sort(nums)));
    }
}
