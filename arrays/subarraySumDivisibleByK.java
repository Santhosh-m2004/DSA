public class subarraySumDivisibleByK {
    public static  int subarraysDivByK(int[] nums, int k) {
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum%k==0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] nums={4,5,0,-2,-3,1};
        int k=5;
        System.out.println(subarraysDivByK(nums,k));

    }
}
