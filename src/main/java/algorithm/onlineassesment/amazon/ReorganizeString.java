package algorithm.onlineassesment.amazon;

import java.util.*;

public class ReorganizeString {
    private static class CharCount{
        Character ch;
        int count;
        public CharCount(Character ch,int count){
            this.ch = ch;
            this.count = count;
        }
    }
    public String reorganizeString(String S) {
        int len = S.length();
        PriorityQueue<CharCount> pq = new PriorityQueue<>((a,b)-> Integer.compare(b.count,a.count));
        Map<Character, Integer> map = new HashMap<>();
        for (char ch :S.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()){
//            if(entry.getValue() > (len+1)/2){
//                return "";
//            }

            pq.offer(new CharCount(entry.getKey(), entry.getValue()));
        }
        StringBuffer sb = new StringBuffer();
        while (pq.size() >= 2){
            CharCount top1 = pq.poll();
            CharCount top2 = pq.poll();

            if (sb.length() == 0 || sb.charAt(sb.length()-1)!= top1.ch){
                sb.append(top1.ch);
                sb.append(top2.ch);

            } else if (sb.charAt(sb.length()-1)!= top2.ch){
                sb.append(top2.ch);
                sb.append(top1.ch);
            }else {
                return "";
            }

            if (--top1.count>0){
                pq.offer(top1);
            }

            if (--top2.count>0){
                pq.offer(top2);
            }
        }

        if (!pq.isEmpty()){
           CharCount top = pq.poll();
           if (top.count > 1){
               return "";
           }
           sb.append(top.ch);
        }
    return sb.toString();
    }
}
