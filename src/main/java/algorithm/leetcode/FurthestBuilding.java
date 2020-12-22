package algorithm.leetcode;

import java.util.PriorityQueue;

public class FurthestBuilding {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> Integer.compare(b,a));
        int sum = 0 ;
        if (heights.length<=1){
            return heights.length;
        }
        int i = 1;
        for ( ; i < heights.length ; i++){
            int prev = heights[i-1];
            int curr = heights[i];

            if (curr < prev){
                continue;
            }

            int diff = curr-prev;
            sum += diff;
        //    System.out.println("sum "+sum);
            pq.offer(diff);
       //     System.out.println("pq "+pq);
            if (ladders ==0 && sum > bricks){
                break;
            }
                while (ladders>0 && sum > bricks){
                    int top = pq.poll();
                    sum -= top;
                    ladders--;
                }

        }
        return i-1;
    }

    public static void main(String[] args) {


        FurthestBuilding furthestBuilding = new FurthestBuilding();
        int[] heights = {4,2,7,6,9,14,12};
        int bricks = 5;
        int ladders = 1;
        System.out.println(furthestBuilding.furthestBuilding(heights, bricks, ladders));
        int[] heights1 = {4,12,2,7,3,18,20,3,19};
        int bricks1 = 10;
        int ladders1 = 2;
        System.out.println(furthestBuilding.furthestBuilding(heights1, bricks1, ladders1));

        int[] heights2 = {14,3,19,3};
        int bricks2 = 17;
        int ladders2 = 0;
        System.out.println(furthestBuilding.furthestBuilding(heights2, bricks2, ladders2));
    }
}
