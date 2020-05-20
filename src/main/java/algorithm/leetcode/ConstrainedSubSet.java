package algorithm.leetcode;

import java.util.*;

public class ConstrainedSubSet {
    public int result;
    public int maxSoFar;
    public int constrainedSubsetSum(int[] nums, int k) {
        result = nums[0];
        maxSoFar = Integer.MIN_VALUE;
        for (int num: nums){
            maxSoFar = Math.max(maxSoFar, num);
        }
        Map<String, Integer> map = new HashMap<>();
        return dfs(nums, -1 , 0, k, map);
    }

    private int dfs(int[] nums, int i , int j ,int  k,Map<String, Integer> map ){
        String str = i+"_"+j;
        if (map.containsKey(str)){
       //     System.out.println("str -- "+str);
            return map.get(str);
        }
        if (j == nums.length){
            return  Math.min(0,maxSoFar);
        }
        int max1 = Math.min(0,maxSoFar);
        if (i==-1 || (i < j && j-i <=k)){
            int sum1 = nums[j]+dfs(nums, j ,j+1,  k, map);
            int sum2 = dfs(nums, i , j+1, k, map);
            int currMax = Math.max(sum1, sum2);
            max1 = Math.max(currMax, max1);
        }
     //   int sum3 = dfs(nums, i, j+1, k, map);
     //    int max = Math.max(sum3, max1);
        result = Math.max(result, max1);
        map.put(str, max1);
        return max1;

    }
}
