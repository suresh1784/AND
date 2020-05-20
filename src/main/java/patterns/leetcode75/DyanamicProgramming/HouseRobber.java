package patterns.leetcode75.DyanamicProgramming;

import java.util.*;

public class HouseRobber {
    public static int rob(int[] nums) {
        Map<String, Integer> map = new HashMap<>();
        return dfs(nums, 0, false, map);
    }

    public static int dfs(int[] nums, int index, boolean start, Map<String, Integer> map){
        if (map.get(index+"_"+start)!= null){
            return map.get(index+"_"+start);
        }
        if (!start && index>=nums.length){
            return 0;
        }

        if (start && index+1>= nums.length){
            return 0;
        }

        int c1 = nums[index] + dfs(nums, index+2, start || index==0, map);
        int c2 = dfs(nums, index+1,start, map);
        map.put(index+"_"+start,Math.max(c1, c2) );
        return map.get(index+"_"+start);
    }

    public static void main(String[] args){
        int[] input = {7,3,5,10};
        System.out.println(rob(input));
    }
}
