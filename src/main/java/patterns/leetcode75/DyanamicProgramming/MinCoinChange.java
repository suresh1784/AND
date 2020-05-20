package patterns.leetcode75.DyanamicProgramming;

public class MinCoinChange {
    public static int coinChange(int[] coins, int amount) {
       return dfs(coins, amount, 0);
    }

    static int dfs(int[] coins, int amount, int index){
        if (index >= coins.length){
            return Integer.MAX_VALUE;
        }

        if (amount ==0 ){
            return 0;
        }


        int c1 = Integer.MAX_VALUE;
        if (amount-coins[index]>=0) {
            int res = dfs(coins, amount - coins[index], index);
            if (res!= Integer.MAX_VALUE){
                c1 = res+1;
            }
        }

        int c2 = dfs(coins, amount, index+1);
        return Math.min(c1,c2);

    }


    public static void main(String[] args){
        int[] coins = {2};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

}
