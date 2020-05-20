package patterns.leetcode75.Interval;

import java.util.*;

public class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals==null || intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> Integer.compare(intervals[a][1],intervals[b][1]));
        pq.offer(0);
        int max = 0 ;
        for (int i = 1; i < intervals.length; i++){
         int top = pq.peek();
         int currSize = pq.size();
         max = Math.max(currSize,max);
         int start = intervals[top][0];
         int end = intervals[top][1];
         int currStart = intervals[i][0];
         int currEnd = intervals[i][1];

         if (currStart> end){
             pq.poll();
         }
            pq.offer(i);
        }
        return max;
    }
}
