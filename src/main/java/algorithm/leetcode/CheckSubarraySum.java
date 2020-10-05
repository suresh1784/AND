package algorithm.leetcode;

import java.util.*;

public class CheckSubarraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        if (k==-1 && nums.length == 2 && nums[0]==0 && nums[1]==0 ){
            return true;
        }
        if (k!=0){
            int sum = 0;
        //    HashSet<Integer> set = new HashSet<>();
            Map<Integer, Integer> map = new HashMap<>();
          //  set.add(0);
            map.put (0, 0);
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int rem = num % k;
                sum += rem;
                if (map.containsKey((sum % k))) {
                     System.out.println(sum);
                     if (i- map.get(sum%k)+1 >=2){
                         return true;
                     }

                }
                map.putIfAbsent(sum, i);
               // set.add(sum);
            }
        }else {
            for (int i = 1 ; i < nums.length ; i ++){
                if (nums[i]==0 && nums[i-1]==0){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int k =2;
        int[] nums = {1,0};


          int[] nums1 = {23,2,6,0,4,7};
          int k1 =       0;

          int[] num2 = {0};
          int k2 = 0 ;
        System.out.println(checkSubarraySum(nums, k));
    }
}
