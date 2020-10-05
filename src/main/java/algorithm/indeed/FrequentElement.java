package algorithm.indeed;
import java.util.*;
import java.util.Map.Entry;

public class FrequentElement {


    public static void main(String[] args){
        int k = 4;
        int[] num = {1,2,1,2,3,1,4,5,5,5,5,9};
        System.out.println(freqElement(num, k));
        } //main

    static List<Integer> freqElement(int[] num , int k ){
        List<Integer> res = new ArrayList<>();

        Map<Integer, Integer>  map = new HashMap<>();
        for (int i : num){
           map.put (i, map.getOrDefault(i,0)+1);
        }

        Queue<Entry<Integer,Integer>> queue = new PriorityQueue<>((o1,o2) ->
        {
            if (o1.getValue() > o2.getValue()){
                return -1;
            }else if (o1.getValue() < o2.getValue()){
                return 1;
            }else{
                return 0;
            }

        });

        for (Entry<Integer,Integer> e : map.entrySet()){
            queue.offer(e);
        }

        while (k >=0){
            k--;
            res.add(queue.poll().getKey());
        }

        return res;
    }  // freqElement
}
