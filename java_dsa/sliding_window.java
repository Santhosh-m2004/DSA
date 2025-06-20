import java.util.*;
public class sliding_window {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the window size");
        int w=s.nextInt();
        int arr[]={2,3,4,5,6,2,3,4,5};
        int n=arr.length;
        int cur=0;
        for(int i=0;i<w;i++){
            cur+=arr[i];
        }
        int max=cur;
        for(int i=1;i<n-w;i++){
            cur=cur-arr[i-1]+arr[i+w-1];
        
        if(cur>max){
            max=cur;
        }
    }
    System.out.println(max);
    }
}
