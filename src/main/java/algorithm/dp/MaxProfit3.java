package algorithm.dp;

import java.util.Arrays;

//http://www.gorecursion.com/algorithm/2016/11/20/2d-dynamic2.html
public class MaxProfit3 {


    private int dfsCache(int[] prices, int k) {
        int[][] cache = new int[k+1][prices.length];
        for (int i = 0; i <= k; i++)
            Arrays.fill(cache[i], -1);
        int profit = dfsCache(prices, 0, k, cache);
        return profit;
    }
    private int dfsCache(int[] prices, int pos, int k, int[][] cache) {
        if (k == 0 || pos == prices.length)
            return 0;
        if (k >= prices.length-pos) // Version 2
            return maxProfitII(prices, pos);
        if (cache[k][pos] != -1)
            return cache[k][pos];
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = pos; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            int diff = prices[i] - min;
            if (diff > 0)
                diff += dfsCache(prices, i+1, k-1, cache);
            profit = Math.max(profit, diff);
        }
        cache[k][pos] = profit;
        return profit;
    }

    public int maxProfit(int[] prices) {
        return maxProfitII(prices, 0);
    }
    private int maxProfitII(int[] prices, int pos) {
        int profit = 0;
        for (int i = pos+1; i < prices.length; i++) {
            int diff = prices[i] - prices[i-1];
            if (diff > 0)
                profit += diff;
        }
        return profit;
    }
}
