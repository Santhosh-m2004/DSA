package arrays;
import java.util.*;
public class stock_buy_sell {
    public static void main(String[] args){
        int[] arr={2,3,4,1,5,6};
        int minprice=Integer.MAX_VALUE;
        int maxProfit=0;
        for (int price:arr){
            if(price<minprice){
            minprice=price;
            }
            else{
                maxProfit=Math.max(maxProfit,(price-minprice));
            }
        }
        System.out.println(maxProfit);
    }
}
