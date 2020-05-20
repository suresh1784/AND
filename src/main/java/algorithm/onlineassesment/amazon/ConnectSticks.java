package algorithm.onlineassesment.amazon;

import java.util.PriorityQueue;

public class ConnectSticks {
    public int connectSticks(int[] sticks) {
        int sum = 0 ;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick : sticks){
            pq.offer(stick);
        }

        while (pq.size()>1){
            int val1 = pq.poll();

            int val2 = pq.isEmpty() ? 0 : pq.poll();
            int currSum = val1+val2;
            sum+= currSum;
            pq.offer(currSum);
        }

        return sum;
    }
}
