package algorithm.leetcode;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MinOperationsV1 {
    public static int minOperations(int[] nums, int x) {
        return helper(nums, x, 0 , nums.length-1);
    }

    public static  int helper (int[] nums, int x, int start, int end ){
        if (x < 0 ){
            return Integer.MAX_VALUE ;
        }

        if (start >= end){
            return Integer.MAX_VALUE ;
        }

        if (x==0){
            return 0;
        }
        PriorityQueue<Map.Entry<Double, List<Integer>>> pq = new PriorityQueue<>((a, b) -> Double.compare(a.getKey(), b.getKey()));
        int fromStart = helper(nums, x-nums[start], start+1, end);
        int fromEnd = helper(nums, x-nums[end], start, end-1);

        return Math.min(fromEnd, fromStart)+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,4,2, 3};
        int x = 5;
     //   System.out.println(minOperations(nums, x));
        int[] nums1 = {3,2,20,1,1,3};
        int x1 = 10;
        System.out.println(minOperations(nums1, x1));

    }
}
