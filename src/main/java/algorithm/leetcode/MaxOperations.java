package algorithm.leetcode;

import java.util.Arrays;

public class MaxOperations {
    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0 ;
        int j = nums.length-1;
        int count = 0 ;
        while (i < j){
           int sum = nums[i]+nums[j];
           if (sum < k){
               i++;
           }else if (sum > k){
               j--;
            }else {
               count++;
               i++;
               j--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums  = {1,2,3,4};
        int k = 5;
        System.out.println(maxOperations(nums,k));
        int[] nums1  = {3,1,3,4,3};
        int k1 = 6;
        System.out.println(maxOperations(nums1,k1));
    }
}
