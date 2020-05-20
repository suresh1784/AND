package patterns.leetcode75.DyanamicProgramming;

import java.util.*;
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        Map<String, Integer> map = new HashMap<>();
        int result  =  dfs(coins, amount, 0, map);
        System.out.println(result);
        return result;
    }

    static int dfs(int[] coins, int amount, int index,  Map<String, Integer> map) {
        if (map.get(amount+"_"+index)!= null){
            return map.get(amount+"_"+index);
        }
    if (amount==0){
        return 1;
    }

    if (index >= coins.length){
    return 0;
    }


    int c1 = 0 ;
    if (amount-coins[index]>=0){
        c1 = dfs(coins, amount-coins[index], index, map);
    }

    int c2 = dfs(coins, amount, index+1,map);
    map.put(amount+"_"+index, c1+c2);
   return map.get(amount+"_"+index);
    }

    // f(amount, index) = f(amount-a[i], i)+ f(amount, i+1)
//    public static int coinChange1(int[] coins, int amount){
//      int[][] dp = new int[amount][coins.length+1];
//      for (int i= 0 ; i < coins.length ; i++){
//          dp[0][i] = 1;
//      }
//
//
//      for (int i = 0 ; i < coins.length; i++){
//          for (int j = 1; j < )
//      }
//    }


    public static void main(String[] args){
        int[] coins = {1,2,3};
        int amount = 5;

        System.out.println(coinChange(coins, amount));
    }
}
