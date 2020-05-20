package patterns.leetcode75.Arrays;

import java.util.*;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer>  map = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++){
            if (map.get(target-nums[i])!=null){
                result[0]= map.get(target-nums[i]);
                result[1]= i;
                return result;
            }else {
                map.put(nums[i], i);
            }
        }
    return result;
    }

    public static void main(String[] args){
        int[] nums = {2, 7, 11, 15};
        int target = 9;

       int[]  retult = twoSum(nums, target);
        System.out.println(retult);
    }
}
