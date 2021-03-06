package algorithm.onlineassesment.amazon;
import java.util.*;
public class TopKFreq {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new LinkedList<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b) -> {
            if (a.getValue() != b.getValue())
                return Integer.compare(a.getValue(), b.getValue());
            return b.getKey().compareTo(a.getKey());
        });
        Map<String, Integer> map = new HashMap<>();
        for (String word: words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            pq.offer(entry);
            if (pq.size()>k){
                pq.poll();
            }

        }

        while (!pq.isEmpty()){
            result.add(0,pq.poll().getKey());
        }
        System.out.println(result);
        return result;
    }
}
