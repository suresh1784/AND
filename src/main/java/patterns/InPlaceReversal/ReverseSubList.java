package patterns.InPlaceReversal;

import java.util.*;


class ReverseSubList {

    public static ListNode reverse(ListNode head, int p, int q) {
        // TODO: Write your code here
        ListNode dummyNode = new ListNode(0, head);
        ListNode iter = dummyNode;
        int count = 1;
        while (count++ < p){
            iter = iter.next;
        }

        ListNode next = iter.next;

        while (p++ < q){
            ListNode temp = next.next;
            next.next = temp.next;
            temp.next = iter.next;
            iter.next = temp;
        }


        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
