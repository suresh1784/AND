package algorithm.onlineassesment.amazon;

import java.util.*;

public class LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        Map<Character, Integer> map = new HashMap<>();
        if (a>0)
        map.put('a', a);
        if (b>0)
        map.put('b',b);
        if (c>0)
        map.put('c',c);

        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<Map.Entry<Character,Integer>>(
                (v1,v2)-> Integer.compare(v2.getValue(),v1.getValue()));

        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        Character prev = 'd';
        Character prevPrev = 'd';
        while (!pq.isEmpty()){
            boolean isPqOneSize = pq.size()==1;
           Map.Entry<Character,Integer> top1  = pq.poll();
            Map.Entry<Character,Integer> top2 = null;
           if (!isPqOneSize)
               top2 = pq.poll();

           if(prevPrev== prev && prev ==top1.getKey() ){
               if (isPqOneSize){
                  break;
               }
               sb.append(top2.getKey());
               top2.setValue(top2.getValue()-1);
               if (top2.getValue()>0){
                   pq.offer(top2);
               }
               pq.offer(top1);
               prevPrev = prev;
               prev = top2.getKey();
           }else {
               sb.append(top1.getKey());
               top1.setValue(top1.getValue()-1);
               if (top1.getValue()>0){
                   pq.offer(top1);
               }
               if (!isPqOneSize)
               pq.offer(top2);
               prevPrev = prev;
               prev = top1.getKey();
           }
        }


      return sb.toString();
    }
}
