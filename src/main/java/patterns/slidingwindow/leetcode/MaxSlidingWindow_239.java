package patterns.slidingwindow.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow_239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length ==0 || k==0){
            return new int[0];
        }
        int[] result = new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        int count = 0 ;
        int index = 0;
        int left = 0 ;
        for (int right = 0 ; right < nums.length ; right++){
            int rNum = nums[right];
            count++;
            if (dq.isEmpty()) {
                dq.addFirst(rNum);
            }else {
                int first = dq.getFirst();
//                if (rNum > first) {
                    while (rNum > first) {
                        dq.pollFirst();
                        if (dq.isEmpty()) {
                            break;
                        }
                        first = dq.getFirst();
                    }
                    dq.addFirst(rNum);
      //          }
            }

            if (count == k){
                result[index] = dq.peekLast();
                index++;
            }

            if (count == k){
                int lNum = nums[left];
                left++;
                int last = dq.getLast();
                if (last == lNum){
                    dq.pollLast();
                }
                count--;
            }
        }
        return result;
    }


    public static void main(String[] args){
       int[]  nums = {1,3,-1,-3,5,3,6,7};
       int k = 3;

       int[] nums1 = {1,3,1,2,0,5};

        int[] result = maxSlidingWindow(nums, k);
        for (int i : result){
            System.out.println(i);
        }
    }


}
