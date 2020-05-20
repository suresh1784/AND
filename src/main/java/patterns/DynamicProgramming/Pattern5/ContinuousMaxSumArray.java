package patterns.DynamicProgramming.Pattern5;

public class ContinuousMaxSumArray {
    public static void main(String[] args){
    int[] input = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArray(input));
    }

    static int result;
    public static int maxSubArray(int[] nums) {
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


}
