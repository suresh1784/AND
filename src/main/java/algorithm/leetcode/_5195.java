package algorithm.leetcode;

import java.util.PriorityQueue;

public class _5195 {

    public static class Value{
        Character ch;
        int value;
        int count;
        public Value(Character ch , int value, int count){
            this.ch = ch;
            this.value = value;
            this.count = count;
        }
    }
    public static String longestDiverseString(int a, int b, int c) {

        PriorityQueue<Value> pq = new PriorityQueue<Value>((v1,v2)->{
            if (v1!= v2){
                return Integer.compare(v2.value,v1.value);
            }
            return Integer.compare(v2.count, v1.count);
        });

        pq.offer(new Value('a', a, a));
        pq.offer(new Value('b', b, b));
        pq.offer(new Value('c', c, c));
        StringBuilder sb = new StringBuilder();
        Character prevPrev = '0';
        Character prev = '0';
        int breakCount = 0 ;
        while (!pq.isEmpty()){
            Value top  = pq.poll();
            int count = top.count;
            System.out.println(top.ch);
            if (prevPrev== prev && prev == top.ch){
                if (!pq.isEmpty()) {
                    breakCount++;
                    Value t1 = pq.poll();
                    sb.append(t1.ch);
                    prevPrev = prev;
                    prev = t1.ch;
                    t1.count = t1.count - 1;
                    if (t1.count > 0) {
                        pq.offer(t1);
                    }
                }
                if (breakCount==3){
                break;
                }
                pq.offer(top);
                continue;
            }else {
                breakCount = 0;
                prevPrev = prev;
                prev = top.ch;
            }
            sb.append(top.ch);
            top.count = count-1;
            if (top.count >0)
            pq.offer(top);
        }


        return sb.toString();
    }


    public static void main(String[] args){
       int a = 1, b = 1, c = 7;
        System.out.println(longestDiverseString(a, b, c));
    }
}
