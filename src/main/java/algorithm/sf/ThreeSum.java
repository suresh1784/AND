package algorithm.sf;
import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int k = nums.length-1;
        for (int i = 0 ; i < nums.length; i ++){
            int target = -(nums[i]);
            int j = i+1;
            int sum = 0;
            while (j<k){
                sum = nums[j]+nums[k];

                if (sum == target){
                    List list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                }
                if (sum < target){
                    j++;
                }else {
                    k--;
                }
            }
        }
        return result;
    }


    public static void main (String[] args){
       // int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {0,0,0};
        System.out.println(threeSum(nums));
    }
}
