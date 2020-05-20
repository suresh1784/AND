package patterns.leetcode75.DyanamicProgramming;

import java.util.*;

public class LengthOfLIS {
    public static int lengthOfLIS(int[] nums) {
        Map<String, Integer> map = new HashMap<>();
        int result =  dfs(nums, -1, 0, map)     ;
        return result;
    }

    public static int dfs(int[] nums, int prevIndex, int currIndex, Map<String, Integer> map){
        if (map.get(currIndex+"_"+prevIndex)!=null){
            map.get(currIndex+"_"+prevIndex);
        }
        if (currIndex == nums.length){
            return 0;
        }
        int c1 = 0 ;
        if (prevIndex == -1 || nums[currIndex] > nums[prevIndex]){
            c1 = dfs(nums, currIndex, currIndex+1, map)+1;
        }

        int c2 = dfs(nums, prevIndex, currIndex+1, map);
        map.put(currIndex+"_"+prevIndex,Math.max(c1, c2) );
        return map.get(currIndex+"_"+prevIndex);
    }
    public static void main(String[] args){
       int[] input = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(input));
    }
}
