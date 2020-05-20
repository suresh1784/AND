package algorithm.onlineassesment.amazon;

import java.util.Arrays;

public class TwoSumUniquePairs {
    public int uniquePairs(int[] nums , int target){
        Arrays.sort(nums);
        int count = 0 ;
        int left = 0 , right = nums.length-1;
        while (left < right){
            int curSum = nums[left]+nums[right];
            if (curSum==target){
                count++;
                while (left < right && nums[left]==nums[++left]){

                }
                while (left < right && nums[right] == nums[--right]) {

                }
            }
            if (curSum < target){
                while (left <= right && nums[left]==nums[++left]){

                }
            }else if (curSum > target){
                while (left <= right && nums[right] == nums[--right]) {

                }
            }
        }
        return count;
    }
}
