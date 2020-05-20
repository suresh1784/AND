package patterns.KwayMerge;

import java.util.*;

class SmallestRange {

    static class Node{
        int elementIndex;
        int arrayIndex;

        public Node (int elementIndex, int arrayIndex){
            this.elementIndex = elementIndex;
            this.arrayIndex = arrayIndex;
        }
    }

    public static int[] findSmallestRange(List<Integer[]> lists) {
        int currMax = 0 ;
        PriorityQueue<Node> q = new PriorityQueue<>((a,b)-> (lists.get(a.arrayIndex)[a.elementIndex]- lists.get(b.arrayIndex)[b.elementIndex]));

        for (int  i = 0 ; i < lists.size() ; i++){
            int val = lists.get(i)[0];
            if (val > currMax){
                currMax = val;
            }
            q.offer(new Node(0, i));
        }

        int[] result = new int[2];
        int diff = Integer.MAX_VALUE;

        while (q.size()==lists.size()){
            Node top = q.poll();
            int topVal = lists.get(top.arrayIndex)[top.elementIndex];
            int currDiff = currMax - topVal;
            System.out.println("Min " + topVal + " max "+ currMax);
            if (diff > currDiff){
              result[0]   = topVal;
              result[1] = currMax;
              diff = currDiff;
            }
            if (lists.get(top.arrayIndex).length > top.elementIndex+1){
                int nextVal = lists.get(top.arrayIndex)[top.elementIndex+1];
                System.out.println("Next Val " + nextVal);
                if (nextVal > currMax){
                    currMax = nextVal;
                }
                q.offer(new Node(top.elementIndex+1, top.arrayIndex));
            }

        }


        return result;
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 1, 5, 8 };
        Integer[] l2 = new Integer[] { 4, 12 };
        Integer[] l3 = new Integer[] { 7, 8, 10 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int[] result = SmallestRange.findSmallestRange(lists);
        System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
    }
}