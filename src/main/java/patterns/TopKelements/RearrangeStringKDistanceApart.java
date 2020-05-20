package patterns.TopKelements;
import java.util.*;
class RearrangeStringKDistanceApart {

    static class Node {
        int val;
        long timestamp ;
        public Node(int val){
            this.val = val;
            timestamp   = System.currentTimeMillis();
        }



    }

    public static String reorganizeString(String str, int k) {
        char[] chs = str.toCharArray();
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : chs){
            if (freqMap.containsKey(ch)){
                freqMap.put(ch, freqMap.get(ch)+1);
            }else {
                freqMap.put(ch, 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() -  a.getValue());
        maxHeap.addAll(freqMap.entrySet());
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        while (!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> top = maxHeap.poll();
            sb.append(top.getKey());
            top.setValue(top.getValue()-1);
            queue.offer(top);
            if (queue.size()==k){
                Map.Entry<Character, Integer> top1 = queue.poll();
                if (top1.getValue() > 0){
                    maxHeap.add(top1);
                }
            }
        }

        return sb.length() == str.length() ? sb.toString() : "";

    }


    public static String reorganizeString1(String str, int k) {
        // TODO: Write your code here
        char[] chs = str.toCharArray();
        Map<Character, Node> freqMap = new HashMap<>();
        for (Character ch1 : chs){
            if (freqMap.containsKey(ch1)){
                int val = freqMap.get(ch1).val+1;
                freqMap.put(ch1,new Node(val));
            }else {
                freqMap.put(ch1, new Node(1));
            }
        } // freqMap

        Comparator<Map.Entry<Character, Node>> nodeComparator = (a, b) -> {
            if (a.getValue().val != b.getValue().val){
                return b.getValue().val - a.getValue().val;
            }
            return Long.compare(a.getValue().timestamp , b.getValue().timestamp);
        };

        PriorityQueue<Map.Entry<Character, Node>> maxHeap = new PriorityQueue<Map.Entry<Character, Node>>(nodeComparator);
        maxHeap.addAll(freqMap.entrySet());


        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> indexMap = new HashMap<>();
        int count = 0 ;
        int sameCount = 0;

        while (!maxHeap.isEmpty() && count < str.length()){
            Map.Entry<Character, Node> top = maxHeap.poll();
            Character ch = top.getKey();
            int freqCount = top.getValue().val;

            if (indexMap.containsKey(ch)){
                int prevIndex = indexMap.get(ch);
                if (prevIndex+k<=count){
                    sb.append(ch);
                    indexMap.put(ch, count);
                    top.setValue(new Node(freqCount-1));
                    if (top.getValue().val>0)
                        maxHeap.add(top);
                    sameCount = 0;
                }else{
                    sameCount++;
                    if (sameCount>=str.length()){
                        return "";
                    }
                    maxHeap.add(top);
                    count--;
                }
            } else {
                sb.append(ch);
                indexMap.put(ch, count);
                top.setValue(new Node(top.getValue().val-1));
                if (top.getValue().val>0)
                    maxHeap.add(top);
                sameCount = 0 ;
            }
            count ++;
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aab", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
    }
}



