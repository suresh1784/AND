package algorithm.leetcode;

import java.util.PriorityQueue;

public class MaxSlidingWindow {

    public static void main(String[] args){
      int[] input =  {1,3,-1,-3,5,3,6,7};
      int k = 3;

        int[] input1 =  {};
        int k1 = 0;
        int[] input2 =  {1};
        int k2 = 1;

      int[] result = maxSlidingWindow(input, k);
      for (int i : result){
          System.out.println(i);
      }

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0 ;
        int count = 0 ;
        int i = 0 ;
        if (nums.length==0 && k ==0){
            return new int[0];
        }
        int[] result = new int[nums.length-k+1];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> Integer.compare(b,a));

        for (int right = 0 ; right < nums.length ; right++ ){
            //Increment Counter
            count++;
            maxHeap.offer(nums[right]);
            if (minHeap.size()+1 < maxHeap.size()){
                minHeap.offer(maxHeap.poll());
            }
            if (count == k){
                count--;
                    if (minHeap.size()>=1) {
                        result[i] = Math.max(minHeap.peek(), maxHeap.peek());
                    }else {
                        result[i] = maxHeap.peek();
                    }

                i++;
                // remove the left value from heap

                if (nums[left] <= maxHeap.peek()){
                    maxHeap.remove(nums[left]);
                }else {
                    minHeap.remove(nums[left]);
                }

                if (minHeap.size()+1 < maxHeap.size()){
                    minHeap.offer(maxHeap.poll());
                }

                left++;
            }
        }

        return result;
    }
}
