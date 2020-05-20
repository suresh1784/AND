package patterns.Heap;

import java.util.*;

class MedianOfAStream {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b)-> a - b);
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)-> (b - a));

    public void insertNum(int num) {
        // TODO: Write your code here
        minHeap.offer(num);
        //   4 5 6 7    2 3 4
        if (minHeap.size() > maxHeap.size()+1){
            maxHeap.offer(minHeap.poll());
        }


    }

    public double findMedian() {
        // TODO: Write your code here
        int minSize = minHeap.size();
        int maxSize = maxHeap.size();
        int size = minSize+maxSize;
        if (minSize== 0 ){
            return -1;
        }
        if (size%2 == 0){
            double value = minHeap.peek()+maxHeap.peek();
            return value/2;
        } else if (size%2==1){
            double value = minHeap.peek();
            return value;

        }

        return -1;
    }


    // 3 1

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
