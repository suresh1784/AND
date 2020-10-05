package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class StringCompression {
    public class Pair{
        Character ch ;
        int c;
        public Pair (Character ch , int c){
            this.ch = ch ;
            this.c = c;
        }
    }
    public int getLengthOfOptimalCompression(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.c, b.c));

        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        int count = k ;
        while (!pq.isEmpty() && count >0){
            if (count>0){
                Pair top = pq.poll();
                int c = top.c;
                if (count >= c) {
                    count = count - c;
                } else {
                    count = 0 ;
                    top.c = c-count;
                    pq.offer(top);
                }
            }
        }

        int result = 0 ;
        while (!pq.isEmpty()){
            Pair top = pq.poll();
            int c = top.c;


            result+= c==1 ? 1: Integer.toString(c).length() +1;
        }
        return result;
    }
}
