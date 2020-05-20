package algorithm.onlineassesment.amazon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer>  dq = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        int count = 0 ;
        int left = 0 ;
        for (int right = 0 ; right < nums.length ; right++){
            int rVal = nums[right];
            if (dq.isEmpty()){
                dq.offer(rVal);
            }else {
                if (rVal > dq.getLast()) {
                    while (!dq.isEmpty() && dq.getLast() < rVal) {
                        dq.removeLast();
                    }
                }
                dq.addLast(rVal);
            }

            if (right-left+1 == k){
                result.add(dq.getFirst());
                int lVal = nums[left];
                left++;
                if (lVal == dq.getFirst()){
                    dq.removeFirst();
                }
            }
        }
        System.out.println(result);
        int[] resultPrimitive = result.stream()
                                .mapToInt(Integer::intValue)
                .toArray();
        return resultPrimitive;
    }
}
