package patterns.leetcode75.Arrays;

public class MaxProfit {
    public static int maxProfit(int[] prices) {
        if (prices.length==0){
            return 0;
        }
        int min = prices[0];
        int profit = 0 ;
        for (int price : prices){
            min = Math.min(min , price);
            profit = Math.max(profit, price-min);
        }

        return profit;
    }

    public static void main(String[] args){
      int[] in =  {7,1,5,3,6,4};
        System.out.println(maxProfit(in));
    }
}
