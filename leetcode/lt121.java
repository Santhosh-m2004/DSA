package leetcode;

class lt121 {
    public static int maxProfit(int[] prices) {
        int buy=prices[0];
        int maxi=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>buy){
                int profit=prices[i]-buy;
                maxi=Math.max(maxi,profit);
            }else{
                buy=prices[i];
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}