package patterns.leetcode75.Arrays;

import java.util.*;
//Given an array nums of n integers,
//        are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

public class ThreeSum {
    public static  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0 ; i+2 < len; i++){
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) { // for duplicates
                int start = i + 1;
                int end = len - 1;
                int target = 0 - nums[i];
                while (start < end) {
                    int sVal = nums[start];
                    int eVal = nums[end];
                    int currSum = sVal + eVal;
                    if (currSum == target) {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[start], nums[end])));
                        while (start < end && nums[start] == nums[start+1]) start++; // for duplicates
                        while (start < end && nums[end] == nums[end-1]) end--; // for duplicates
                        start++;
                        end--;
                    } else if (currSum > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] in1 = {-1, 0, 1, 2, -1, -4};
        int[] in = {0,0,0,0,0,0};
        System.out.println(threeSum(in1));
    }
}
