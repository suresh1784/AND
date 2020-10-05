package algorithm.leetcode;

import java.util.*;

public class MinInteger {
    public String minInteger(String num, int k) {
        Map<Integer, List<Integer>> valueMap = new HashMap<>();
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0 ; i <  num.length() ; i++){
            int value = num.charAt(i)-'0';
            indexMap.put(i, value);
            if (!valueMap.containsKey(value)){
                valueMap.put(value, new ArrayList<>());
            }
            valueMap.get(value).add(i);
        }

        PriorityQueue<Map.Entry<Integer, List<Integer>>> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.getKey(), b.getKey()));
        for (Map.Entry<Integer, List<Integer>> entry :  valueMap.entrySet()){
            pq.add(entry);
        }

        while (!pq.isEmpty()){
            Map.Entry<Integer, List<Integer>> top = pq.poll();
            System.out.println(top.getKey());
        }
        return "";
    }

    public static void main(String[] args) {
        String num = "4321";
        int k = 4;
        System.out.println(new MinInteger().minInteger(num, k));
    }
}
