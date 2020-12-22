package algorithm.leetcode;
import java.util.*;

public class MinDeletions {
    public int minDeletions(String s) {
        Map<Character, Integer> freqCount = new HashMap<>();
        Map<Integer, List<Character>> countList = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> Integer.compare(b,a));
        Set<Integer> set = new HashSet<>();
        for (char ch : s.toCharArray()){
            freqCount.put(ch, freqCount.getOrDefault(ch,0)+1);

        }

        for (Map.Entry<Character, Integer> entry : freqCount.entrySet()){
            char ch = entry.getKey();
            int currCount = entry.getValue();
            countList.putIfAbsent(currCount, new ArrayList<>());
            countList.get(currCount).add(ch);
        }

        for (Map.Entry<Integer, List<Character>> entry : countList.entrySet()){
            if (entry.getValue().size()>1){
                set.add(entry.getKey());
                pq.add(entry.getKey());
            }
        }

//        System.out.println("freqCount  "+freqCount);
//        System.out.println("countList  "+countList);
//        System.out.println("pq  "+pq);


        int result = 0 ;
        while (!pq.isEmpty()){
            int top = pq.poll();
            set.remove(top);
            result++;
            List<Character>  charray =  countList.get(top);
            char ch = charray.remove(0);
         //   System.out.println(ch);
            countList.putIfAbsent(top-1, new ArrayList<>());
            countList.get(top-1).add(ch);
            if (countList.get(top-1).size() > 1 && top-1 >0){
                if (!set.contains(top-1)) {
                    pq.add(top - 1);
                    set.add(top-1);
                }
            }

            if (countList.get(top).size() >1){
                if (!set.contains(top)) {
                    pq.add(top);
                    set.add(top);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinDeletions minDeletions = new MinDeletions();
        String s1 = "aab";
        String s2 = "aaabbbcc";
        String s3 = "ceabaacb";
        String s4 = "ceabaacbdd" ;
        System.out.println(s4+"-->   "+minDeletions.minDeletions(s4));
        String[] sarr = {s1, s2, s3,s4};
        for (String s : sarr){
            System.out.println(s+"-->   "+minDeletions.minDeletions(s));
        }

    }
}
