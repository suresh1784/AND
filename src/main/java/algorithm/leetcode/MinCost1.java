package algorithm.leetcode;

import java.util.*;

public class MinCost1 {

    public int minCost(String s, int[] cost) {
        int result = 0 ;
        List<PriorityQueue<Integer>> lists = new ArrayList<>();
        char[] chars = s.toCharArray();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 1 ; i < chars.length ; i++ ){
            if (chars[i]==chars[i-1]){
                if (q.isEmpty()) {
                    q.offer(cost[i-1]);
                }
                q.offer(cost[i]);
            }else {
                if (!q.isEmpty()){
                    lists.add( q);
                }
                q = new PriorityQueue<>();
            }
        }

        if (chars[chars.length-2]==chars[chars.length-1]) {
            lists.add(q);
        }

     //   System.out.println(lists);
        for (PriorityQueue<Integer> qList : lists){
            while (qList.size()>1){
               int top =  qList.poll();
            //    System.out.println("top "+top);
                result+=top;
            }
        }



        return result;
    }

    public static void main(String[] args) {
        MinCost1 min = new MinCost1();
        String s = "aabaa";
        int[] cost = {1,2,3,4,1};


        System.out.println(min.minCost(s, cost));
    }
}
