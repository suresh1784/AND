package algorithm.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        int result = 0 ;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> (Integer.compare(b,a)));
        for (int stone : stones){
            pq.add(stone);
        } // for

        while (!pq.isEmpty()){
            int first = pq.poll();
            int second = 0;
            if (!pq.isEmpty()){
               second = pq.poll();
            }else {
               result = first;
               break;
            }
         //   System.out.println("First "+first);
         //   System.out.println("Second "+second);
            pq.offer(first-second);
        }//while
        return result;
    }


    public static int lastStoneWeightII(int[] stones) {
        Arrays.sort(stones);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> (Integer.compare(b,a)));
        for (int stone : stones){
            pq.add(stone);
        } // for

        return dfs( pq);
    }

    static int dfs ( PriorityQueue<Integer> pq){

        if (pq.size()==1){
            return pq.poll();
        }

        int first = 0;
        int second = 0;
        int third = 0;
        int withFirstAndSecond = Integer.MAX_VALUE;
        int withSecondAndThird = Integer.MAX_VALUE;

        if (!pq.isEmpty()){
            first = pq.poll();
            if (!pq.isEmpty()){
                second = pq.poll();
                pq.offer(first-second);
                withFirstAndSecond = (first-second) - dfs(pq);
                if (!pq.isEmpty()){
                    third = pq.poll();
                    pq.offer(first);
                    pq.offer(second-third);
                    withSecondAndThird =(second-third)-dfs(pq);
                }else {
                    return first - second;
                }
            }
        }

        return Math.min(withFirstAndSecond, withSecondAndThird);
    }






    public static void main(String[] args){
        //[2,7,4,1,8,1]
        int[] input = {2,7,4,1,8,1};
        int[] input1 = {31,26,33,21,40};
        int result = lastStoneWeightII(input1);
        System.out.println(result);

    }
}
