package algorithm.leetcode;

import java.util.*;

public class _5344 {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0 ; i < nums.length ; i++){
            int val = nums[i];
            if (map.containsKey(val)){
                List<Integer> list = map.get(val);
                list.add(i);
                map.put(val, list);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(val, list);
            }
        }
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        int count = 0 ;
        for (int num : nums){
            if (map.containsKey(num)) {
                List<Integer> lists = map.get(num);
                map.remove(num);
                for (int list : lists) {
                    result[list] = count;
                }
            }
          count++;
        }

        return result;
    }

    public static void main(String[] args){
        int[] nums = {8,1,2,2,3};
        int[] nums1 = {6,5,4,8};
        int[] nums2 = {7,7,7,7};
        int[] nums3 = {};
        int[] result = smallerNumbersThanCurrent(nums3);
        for (int val : result){
            System.out.println(val);
        }
    }
}
