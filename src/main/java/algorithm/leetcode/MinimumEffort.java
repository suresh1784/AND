package algorithm.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;



public class MinimumEffort {

    public static class Pair {
        int num1;
        int num2;
        public Pair (int num1, int num2){
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "num1=" + num1 +
                    ", num2=" + num2 +
                    '}';
        }


    }
    public static int minimumEffort(int[][] tasks) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> {
            int diff1 = a.num2-a.num1;
            int diff2 = b.num2-b.num1;

            if (diff1 == diff2){
                return Integer.compare(b.num2, a.num2);
            }

            return Integer.compare(diff2, diff1);

        });


        for (int[] task : tasks){
            pq.add(new Pair(task[0], task[1]));
        }

        int result = 0 ;
        int remaining = 0 ;
        System.out.println(pq);

        while(!pq.isEmpty()){
            Pair top = pq.poll();
            int required = top.num2;
            int need = 0;
            if (required > remaining){
                need = required-remaining;
                remaining = 0 ;
            }else {
                remaining = remaining-required;
            }

            result+= need;

            remaining += top.num2- top.num1;


        }

        return result;
    }

    public static void main(String[] args) {
        int[][] in0 = {{1,1},{1,3}};
        int[][] in = {{1,7},{2,8},{3,9},{4,10},{5,11},{6,12}};
        int[][] in1 = {{1,3},{2,4},{10,11},{10,12},{8,9}};
        System.out.println(minimumEffort(in0));
    }
}
