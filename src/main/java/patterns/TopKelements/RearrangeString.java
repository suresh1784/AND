package patterns.TopKelements;
import java.util.*;
class RearrangeString {

    public static String rearrangeString(String str) {
        char[] chs = str.toCharArray();
        Map<Character, Integer> freqMap = new HashMap<>();
        for (Character ch1 : chs){
            if (freqMap.containsKey(ch1)){
                freqMap.put(ch1, freqMap.get(ch1)+1);
            }else {
                freqMap.put(ch1, 1);
            }
        } // freqMap

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a,b)-> Integer.compare(b.getValue(), a.getValue()));
        maxHeap.addAll(freqMap.entrySet());
        StringBuilder sb = new StringBuilder();
        Character prevCh = null;
        int prevCount = 0 ;
        while (!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> top = maxHeap.poll();
            if (prevCh!= null && prevCh == top.getKey()){
                prevCount++;
                if (prevCount == str.length()){
                    break;
                }
                maxHeap.offer(top);
                continue;
            }else {
                int count = top.getValue();
                if (count > 1) {
                    top.setValue(top.getValue() - 1);
                    maxHeap.offer(top);
                }

                sb.append(top.getKey());
            }
            prevCh = top.getKey();
        }

        return sb.length()== str.length() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
    }
}