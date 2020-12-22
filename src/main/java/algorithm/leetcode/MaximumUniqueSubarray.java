package algorithm.leetcode;
import java.util.*;
public class MaximumUniqueSubarray {
    public static int maximumUniqueSubarray(int[] nums) {
        int left = 0 ;
        Set<Integer> set = new HashSet<>();
        int sum = 0 ;
        int max = 0 ;
        for (int right = 0 ; right < nums.length ; right++){
            int rVal = nums[right];
            if (!set.contains(rVal)){
                set.add(rVal);
                sum+= rVal;
            }else {
                while(set.contains(rVal)){
                    int lVal = nums[left];
                    sum-= lVal;
                    set.remove(lVal);
                    left++;
                }
                sum+= rVal;
                set.add(rVal);
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,1,2,5,2,1,2,5};
        System.out.println(maximumUniqueSubarray(nums));
    }


}
