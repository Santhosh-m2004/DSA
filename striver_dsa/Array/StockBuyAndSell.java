package Array;
import java.util.*;
public class StockBuyAndSell {

    static int res(int[] prices){
        int n=prices.length;
        if(n<2){
            return 0;
        }

        int profit=0;
        int buy=prices[0];
        for(int i=1;i<n;i++){
            if(prices[i]<buy){
                buy=prices[i];
            }else{
                profit=Math.max(profit,prices[i]-buy);
            }
        }


        return profit;
    }
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println((res(prices)));
    }
}
