package algorithm.leetcode;

import algorithm.indeed.FrequentElement;

import java.util.*;

public class IsPossibleDivide {

    public class Freq {
        int num;
        int freq;

        public Freq(int num, int freq){
            this.freq = freq;
            this.num = num;
        }
    }

    public boolean isPossibleDivide(int[] nums, int k) {
        // length %k == 0
        if (nums.length%k>0){
            return false;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num: nums){
            freqMap.put(num,freqMap.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.num, b.num));
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            pq.offer(new Freq(entry.getKey(),entry.getValue()));
        }

        int expected = nums.length/k;
        int count = 0 ;
        Stack<Freq> q = new Stack<>();
        while (!pq.isEmpty()){
            Freq top = pq.poll();
            if (top.freq==0){
                continue;
            }
            if ((!q.isEmpty() && q.peek().num+1==top.num) || q.isEmpty()){
                top.freq = top.freq-1;
                q.push(top);
                if (q.size()==k){
                    count++;
                    pq.addAll(q);
                    q = new Stack<>();
                }
            }else {
                return false;
            }
        }

        if (count != expected){
            return false;
        }

        return true;

    }

}
