package algorithm.leetcode;
import java.util.*;

public class _5376 {

    public static List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<>();
    if (nums == null || nums.length== 0){
        return result;
    }

    Arrays.sort(nums);
    int sum = 0 ;
    for (int num : nums){
        sum+= num;
    }
    int currSum = 0;
    for (int i = nums.length-1 ; i >=0 ; i--){
        result.add(nums[i]);
        currSum += nums[i];
        if (currSum > (sum-currSum)){
            return result;
        }
    }

    return result;
    }

    public static void main(String[] args){
       int[] in1 = {4,3,10,9,8} ;
       int[] in2 = {4,4,7,6,7};
       int[] in3 = {6};

       int[][] in = {in1, in2, in3};

       for (int[] i : in){
           System.out.println(minSubsequence(i));
       }
    }
}
