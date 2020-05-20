package algorithm.onlineassesment.amazon;

import java.util.*;

public class KDistanceApart {
    public static class CharCount{
        Character ch;
        int count;
        public CharCount(Character ch, int count){
        this.ch = ch;
        this.count = count;
        }
    }
    public String rearrangeString(String s, int k) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<CharCount> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.count, a.count));
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new CharCount(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        Queue<CharCount> q = new LinkedList();
        while (!pq.isEmpty()) {
            CharCount top = pq.poll();
            sb.append(top.ch);
            top.count = top.count - 1;
            q.offer(top);
            if (q.size() < k) {
                continue;
            }

            CharCount topQ = q.poll();
            if (topQ.count > 0) {
                pq.offer(topQ);
            }
        }

        return (sb.toString().length() == s.length()) ? sb.toString() : "";
    }
}
