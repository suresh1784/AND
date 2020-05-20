package patterns.InPlaceReversal;

import java.util.List;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }

    ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}

class ReverseLinkedList {

    public static ListNode reverse(ListNode head) {
        // TODO: Write your code here
        ListNode temp = null;

        while (head!=null){
            ListNode next = head.next;
            head.next =  temp;
            temp = head;
            head = next;
        }

        return temp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

        ListNode result = ReverseLinkedList.reverse(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}