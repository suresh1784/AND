package algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarray {
    public static int minSubArrayLen(int s, int[] nums) {
        Deque<Integer> dq = new ArrayDeque<>();
        int len = -1;
        int sum = 0 ;
        for (int num : nums){
            sum += num;
            dq.addLast(num);
            while (sum >= s){

                len = len==-1 ? dq.size() : Math.min(dq.size(), len);
                sum -= dq.removeFirst();
            }
        }

        return len;
    }

    public static void main(String[] args) {
       int[] nums = {1,3, 2,-1,2};
       int[] nums1 = {84,-37,32,40,95};
       int k = 3;
       int k1 = 167;

        System.out.println(minSubArrayLen( k1,nums));

    }
}
