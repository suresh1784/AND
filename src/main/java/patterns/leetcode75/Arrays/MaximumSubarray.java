package patterns.leetcode75.Arrays;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int result = nums[0];
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1 ; i < n; i++){
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }

        return result;
    }
    static int result;
    public static int maxSubArrayV1(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        result = nums[0];
            Integer[] dp =  new Integer[nums.length];
         dfs(nums, nums.length-1);
        return result;
    }



    static int dfs(int[] nums, int i ){
        if (i==0 ){
            return nums[0];
        }

        int currMax = Math.max(dfs(nums, i-1) + nums[i], nums[i]);
        result = Math.max(result, currMax);

        return currMax;
    }

    public static void main(String[] args){
        int[] input1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] input = {1};
     //   {-2, -3, 4, -1, -2, 1, 5, -3};
       //  Output: 6  [4,-1,2,1]
        System.out.println(maxSubArray(input));
        System.out.println(maxSubArrayV1(input));
    }
}
