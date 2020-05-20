package patterns.DynamicProgramming;

import java.util.*;

public class StocksBuysAndSell {


//    Input:
//    Price = [10, 22, 5, 75, 65, 80]
//    K = 2
//    Output:  87
//    Trader earns 87 as sum of 12 and 75
//    Buy at price 10, sell at 22, buy at
//5 and sell at 80
//
//    Input:
//    Price = [12, 14, 17, 10, 14, 13, 12, 15]
//    K = 3
//    Output:  12
//    Trader earns 12 as the sum of 5, 4 and 3
//    Buy at price 12, sell at 17, buy at 10
//    and sell at 14 and buy at 12 and sell
//    at 15
//
//    Input:
//    Price = [100, 30, 15, 10, 8, 25, 80]
//    K = 3
//    Output:  72
//    Only one transaction. Buy at price 8
//    and sell at 80.
//
//    Input:
//    Price = [90, 80, 70, 60, 50]
//    K = 1
//    Output:  0
//    Not possible to earn.
    public static void main(String[] args){
        int[] prices1 = {10, 22, 5, 75, 65, 80}; // k = 2
        int[] prices2 = {12, 14, 17, 10, 14, 13, 12, 15};
        System.out.println(maxProfit(prices1, 2));

    }


    public static int  maxProfit(int[] prices, int k ){
        System.out.println( maxProfitRecursive(prices,k, 0, 0));
        Integer[][][] d =new  Integer[prices.length+1][k+1][2];
        Map<String, Integer> map = new HashMap<>();
       // return  maxProfitRecursive(prices,k, 0, 0);
      // return  maxProfitRecursiveOptimizeV1(prices,k, 0, 0, d);
        return  maxProfitRecursiveOptimizeV2(prices,k, 0, 0,map);
    }


    public static int maxProfitRecursive(int[] prices, int k, int day, int isBought){
        if (day>=prices.length || k==0){
            return 0;
        }
        int max = 0 ;
        if (isBought==0){
            max =  Math.max(maxProfitRecursive(prices,k, day+1, 1)- prices[day] ,
                    maxProfitRecursive(prices,k, day+1, 0));
        } else {
            max =  Math.max(maxProfitRecursive(prices, k-1, day+1, 0)+prices[day],
                    maxProfitRecursive(prices,k, day+1, 1) );
        }
        return max;
    } // maxProfitRecursive


    public static int maxProfitRecursiveOptimizeV1(int[] prices, int k, int day, int isBought, Integer[][][] d){
        if (day>=prices.length || k==0){
            return 0;
        }
//        System.out.println("Day "+day + " k  "+ k  + " isBought "+isBought);
//        System.out.println("d[day][k][isBought] "+d[day][k][isBought]);
        if (d[day][k][isBought]!=null){
            return d[day][k][isBought];
        }


        if (isBought==0){
            d[day][k][0] =  Math.max(maxProfitRecursiveOptimizeV1(prices,k, day+1, 1, d)- prices[day] ,
                    maxProfitRecursiveOptimizeV1(prices,k, day+1, 0, d));
        } else {
            d[day][k][1] =  Math.max(maxProfitRecursiveOptimizeV1(prices, k-1, day+1, 0, d)+prices[day],
                    maxProfitRecursiveOptimizeV1(prices,k, day+1, 1, d) );
        }
        return  d[day][k][isBought];
    }

    public static int maxProfitRecursiveOptimizeV2(int[] prices, int k, int day, int isBought, Map<String, Integer> map){
        if (day>=prices.length || k==0){
            return 0;
        }
        String str = day+"_"+k+"_"+isBought;
        if (map.containsKey(str)){
            return map.get(str);
        }

        int max = 0 ;
        if (isBought==0){
            max =  Math.max(maxProfitRecursiveOptimizeV2(prices,k, day+1, 1, map)- prices[day] ,
                    maxProfitRecursiveOptimizeV2(prices,k, day+1, 0, map));
        } else {
            max =  Math.max(maxProfitRecursiveOptimizeV2(prices, k-1, day+1, 0, map)+prices[day],
                    maxProfitRecursiveOptimizeV2(prices,k, day+1, 1, map) );
        }
        map.put(str, max);
        return  map.get(str);
    }
}
