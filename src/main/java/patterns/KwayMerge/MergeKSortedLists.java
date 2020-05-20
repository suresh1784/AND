package patterns.KwayMerge;

import java.util.*;

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class MergeKSortedLists {

    public static ListNode merge(ListNode[] lists) {

        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        // TODO: Write your code here
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.value,b.value));
        for (ListNode list : lists){
            pq.add(list);
        }

        while (!pq.isEmpty()){
            ListNode top = pq.poll();
            if (top!=null){
                result.next = top;
                result = result.next;
                if (top.next!= null)
                pq.offer(top.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = MergeKSortedLists.merge(new ListNode[] { l1, l2, l3 });
        System.out.print("Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}

