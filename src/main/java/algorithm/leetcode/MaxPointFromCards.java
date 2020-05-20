package algorithm.leetcode;

import java.util.*;

public class MaxPointFromCards {
    public int maxScore(int[] cardPoints, int k) {
    Map<String, Integer> map = new HashMap<>();
    int[][] dp = new int[k][k];
    return dfs(cardPoints, k , 0 , cardPoints.length-1, map, dp);
    }

    private int dfs(int[] cardPoints, int k , int left, int right,Map<String, Integer> map , int[][] dp){
        String str =  left+"_"+right ;//k+"_"+left+"_"+right;
        if (map.containsKey(str)){
           // System.out.println("--");
            return map.get(str);
        }
        if (k==0){
            return 0 ;
        }

        int sumLeft =  cardPoints[left] +dfs(cardPoints, k-1, left+1, right, map, dp);
        int sumRight = cardPoints[right]+dfs(cardPoints, k-1, left, right-1, map, dp);
        int max = Math.max (sumLeft, sumRight);
        map.put(str, max);
        return map.get(str);
    }
// dp[i][j] = Math.max(c[i]+dp[i+1][j], c[j]+dp[i][j-1]);



}
