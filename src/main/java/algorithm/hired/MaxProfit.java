package algorithm.hired;

public class MaxProfit {
    public static void main(String[] args){
        long[] prices = {6, 0 , -1, 10};
        System.out.println(solution(prices));
    }

    public static long solution(long[] prices) {
        // Type your solution here
        long profit = 0 ;
        long min = prices[0];
        long max = prices[0];
        long diff = 0 ;

        for (int i = 1; i < prices.length ; i++){
            if (prices[i]< min){
               min = prices[i];
               max = prices[i];
            }

            if (prices[i]> max){
                max = prices[i];
            }

            diff = max - min;
            profit = Math.max(profit, diff);
        }
        return profit;
    }
}
