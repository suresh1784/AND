package patterns.KwayMerge;

import java.util.*;

class KthSmallestInMSortedArrays {

    static class  ArrayNode {
        Integer value;
        Integer index;

        public ArrayNode(Integer value, Integer index){
           this.value = value;
            this.index = index;
        }
    }


    static class IndexNode{
        Integer elementIndex;
        Integer arrayIndex;
        public IndexNode(Integer elementIndex, Integer arrayIndex){
            this.elementIndex = elementIndex;
            this.arrayIndex = arrayIndex;
        }
    }

    public static int findKthSmallest(List<Integer[]> lists, int k) {
        PriorityQueue<IndexNode> q = new PriorityQueue<IndexNode>((a,b)-> (lists.get(a.arrayIndex)[a.elementIndex] - lists.get(b.arrayIndex)[b.elementIndex]));
        for (int i = 0 ; i < lists.size(); i++){
            q.offer(new IndexNode(0, i));
        }

        while (!q.isEmpty()){
            IndexNode top = q.poll();
            k--;
            System.out.println(" K "+ k + " value "+ lists.get(top.arrayIndex)[top.elementIndex]);
            if (k == 0 ){
                return lists.get(top.arrayIndex)[top.elementIndex];
            }
            if (lists.get(top.arrayIndex).length > top.elementIndex+1)
            q.offer(new IndexNode(top.elementIndex+1,top.arrayIndex ));
        }
    return -1;
    }

    public static int findKthSmallestv1(List<Integer[]> lists, int k) {
        PriorityQueue<ArrayNode> q = new PriorityQueue<>((a,b)-> Integer.compare(a.value, b.value));
        List<Iterator<Integer>> listIterable = new ArrayList<>();
        for (Integer[] list : lists){
           listIterable.add(Arrays.asList(list).iterator());
        }

        for (int i = 0 ; i < listIterable.size(); i++){
            Iterator<Integer>   iter =  listIterable.get(i);
            if (iter.hasNext())
            q.offer(new ArrayNode(iter.next(), i));
        }

        while (!q.isEmpty()){
            ArrayNode top = q.poll();
            k--;
            System.out.println("k "+k +" value "+ top.value);
            if (k== 0){
                return top.value;
            }

            Iterator<Integer>   iter =  listIterable.get(top.index);
            if (iter.hasNext()){
                q.offer(new ArrayNode(iter.next(), top.index));
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 7 };
        Integer[] l3 = new Integer[] { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}