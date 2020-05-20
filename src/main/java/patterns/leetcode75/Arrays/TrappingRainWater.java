package patterns.leetcode75.Arrays;

public class TrappingRainWater {
    public static int trap(int[] height){
        int len = height.length;
        int currMax = 0 ;
        int[] res = new int[height.length];
        for (int i = 0 ; i < len; i++ ){
            int currVal = height[i];
            if (currVal> currMax){
                currMax = currVal;
            }

            res[i]= currMax-currVal;
        }
        currMax = 0 ;
        int sum = 0 ;
        for (int i = len-1; i >=0 ; i--){
            int currVal = height[i];
            if (currVal > currMax){
                currMax = currVal;
            }

            res[i] = Math.min(res[i], currMax-currVal);
            sum += res[i];
        }

        return sum;
    }

    public static void main(String[] args){
        int[] height = {};
        System.out.println(trap(height));
    }
}
