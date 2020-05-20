package patterns.mock;

public class CoinChange {

    public static void main(String[] args){
        int[]  coins = {1, 2, 5};
        System.out.println(coinChange(coins, 11));
    }
    public static int coinChange(int[] coins, int amount) {

        Integer[][] dp = new Integer[coins.length][amount + 1];
        int result = countChangeRecursive(dp, coins, amount, 0);
        return (result == Integer.MAX_VALUE ? -1 : result);
    }

    private static int countChangeRecursive(Integer[][] dp, int[] denominations, int total, int currentIndex) {
        // base check
        if (total == 0)
            return 0;

        if(denominations.length == 0 || currentIndex >= denominations.length)
            return Integer.MAX_VALUE;

        // check if we have not already processed a similar sub-problem
        if(dp[currentIndex][total] == null) {
            // recursive call after selecting the coin at the currentIndex
            // if the coin at currentIndex exceeds the total, we shouldn't process this
            int count1 = Integer.MAX_VALUE;
            if( denominations[currentIndex] <= total ) {
                int res = countChangeRecursive(dp, denominations, total - denominations[currentIndex], currentIndex);
                if(res != Integer.MAX_VALUE){
                    count1 = res + 1;
                }
            }

            // recursive call after excluding the coin at the currentIndex
            int count2 = countChangeRecursive(dp, denominations, total, currentIndex + 1);
            dp[currentIndex][total] = Math.min(count1, count2);
        }
        return dp[currentIndex][total];
    }
}
