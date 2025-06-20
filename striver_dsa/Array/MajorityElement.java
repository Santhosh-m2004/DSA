package Array;

public class MajorityElement {

    static int res(int[] nums){
        int count=1;
        int num=nums[0];
        for(int i=1;i<nums.length;i++){
            if(count==0){
                num=nums[i];
            }
            else if(nums[i]==num){
                count++;
            }else{
                count--;
            }
        }
        return num;


    }
    public static void main(String[] args) {
        int[] nums={2,2,1,1,1,2,2};
        
        System.out.println(res(nums));
    }
}
