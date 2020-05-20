package patterns.leetcode75.Arrays;

public class MaxProductSubarray {
    public static int maxProduct(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int result = nums[0];
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1 ; i < n ; i++){
            int currMax = max;
             max  = Math.max(nums[i]*max,Math.max(nums[i]*min, nums[i]));
             min  = Math.min(nums[i]*currMax,Math.min(nums[i]*min, nums[i]));
             result = Math.max(result, max);
        }
        return result;
    }

    public static void main(String[] args){
       int[] in =  {-4,-3,-2};
        System.out.println(maxProduct(in));
    }
}
