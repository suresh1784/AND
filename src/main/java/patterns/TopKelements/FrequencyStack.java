package patterns.TopKelements;

import java.util.*;

class FrequencyStack {

    static class Node {
        int val;
        int freq;
        long timeStamp;

        public Node(int val, int freq){
            this.val = val;
            this.freq = freq;
            this.timeStamp = System.currentTimeMillis();
        }
    }


    PriorityQueue<Node> heap ;
    Comparator<Node> nodeComparator = (a, b) -> {
        if (a.freq != b.freq){
            return b.freq - a.freq;
        }
        return Long.compare(b.timeStamp , a.timeStamp);
    };

    Map<Integer, Integer> freqMap;

    public FrequencyStack(){

    this.heap = new PriorityQueue<>(nodeComparator);
     this.freqMap = new HashMap<>();
    }

    public void push(int num) {
    freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
    heap.add(new Node(num, freqMap.get(num)));
    }

    public int pop() {
    Node node = heap.poll();
    int num = node.val;
    if (freqMap.get(num)>1){
        freqMap.put(num, freqMap.get(num)-1);
    }else {
        freqMap.remove(num);
    }
    return num;
    }

    public static void main(String[] args) {
        FrequencyStack frequencyStack = new FrequencyStack();
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(3);
        frequencyStack.push(2);
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(5);
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
    }
}
