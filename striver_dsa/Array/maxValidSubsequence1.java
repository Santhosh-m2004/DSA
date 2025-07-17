package Array;

public class maxValidSubsequence1 {
    public static int maximumLength(int[] nums) {
        int count=1;
        int evenCount=0;
        int oddCount=0;
        int alternateCount=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                evenCount++;
            }else{
                oddCount++;
            }
        }
        int prev=nums[0];
        for(int i=1;i<nums.length;i++){
            if(prev%2 != nums[i]%2){
                alternateCount++;
                prev=nums[i];
            }
        }
        return Math.max(alternateCount,Math.max(evenCount,oddCount));
    }

    public static void main(String[] args) {
        int arr[]={1,2,1,1,2,1,2};
        System.out.println(maximumLength(arr));
    }
}
