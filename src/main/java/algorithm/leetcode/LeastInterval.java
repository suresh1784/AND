package algorithm.leetcode;

import com.sun.xml.internal.ws.api.pipe.helper.PipeAdapter;

import java.util.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        int result = tasks.length;
        if (n == 0) {
            return result;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));
        Queue<Pair> q = new LinkedList<>();
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char task : tasks){
            freqMap.put(task, freqMap.getOrDefault(task, 0)+1);
        }

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()){
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        int count = 0 ;
        while (!pq.isEmpty() || !q.isEmpty()){
            if (!pq.isEmpty()){
                Pair top = pq.poll();

                if (top.freq > 0){
                    top.freq = top.freq-1;
                    q.offer(top);
                }
            } else {
                if (q.size()+count <n+1){
                    count++;
                }
            }

            if (q.size()+count ==n+1){
                result+=count;
                while (!q.isEmpty()){
                    Pair top = q.poll();
                    if (top.freq > 0 ){
                        pq.offer(top);
                    }
                }
                q = new LinkedList<>();
                count=0;
            }
        }


        return result;
    }

    private class Pair {
        char ch;
        int freq;

        public Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
}
