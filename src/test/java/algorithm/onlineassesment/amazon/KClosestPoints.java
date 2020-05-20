package algorithm.onlineassesment.amazon;

import java.util.PriorityQueue;
import java.util.*;
public class KClosestPoints {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> Double.compare(Math.sqrt(Math.pow(points[b][0],2)+Math.pow(points[b][1],2)),
                Math.sqrt(Math.pow(points[a][0],2)+Math.pow(points[a][1],2))));

        for (int index = 0 ; index < points.length ; index++){
            pq.offer(index);
            if (pq.size() > K){
                pq.poll();
            }
        }
        int[][] result = new int[K][2];
        int i = 0 ;
        while(!pq.isEmpty()){
            result[i][0]= points[pq.peek()][0];
            result[i][1]= points[pq.poll()][1];
            i++;
        }

        return result;
    }
}
