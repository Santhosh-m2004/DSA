package practice;
// Stock BUy and Sell
public class p5 {
    public static int res(int[] prices){
        int buy=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<buy){
                buy=prices[i];
            }
            else{
                profit=Math.max(profit,prices[i]-buy);
            }
        }
        return profit;

    }
    public static void main(String[] args){
        int[] arr={7,1,5,3,6,4};
        System.out.println(res(arr));
    }
}
