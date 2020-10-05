package algorithm.leetcode;

import java.util.*;

public class MaxNonOverlapping {
    public int maxNonOverlapping(int[] nums, int target) {

        int[] prefixSum = new int[nums.length];

        Map<Integer, Integer> map = new HashMap<>();

        int total = 0 ;
        if (nums[0]== target){
            total++;
        }else{
            prefixSum[0] = nums[0];
            map.put(nums[0], 0);
        }

       // int currIndex = -1 ;
        for (int i = 1 ; i < nums.length ; i++){
            int currSum = prefixSum[i-1]+nums[i];
            prefixSum[i] = currSum;
            if (map.containsKey(currSum-target) ||currSum-target==0  ){
                total++;
           //    currIndex = i;
                map = new HashMap<>();
                prefixSum[i] =  0 ;
            }else {
                map.put(currSum, i);
            }

        }
        return total;
    }
}
