package org.example.solutions;

public class ReverseLinkedList implements DefaultSolution {

    private void reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        while (prev != null) {
            System.out.print(prev.val + "\t");
            prev = prev.next;
        }
    }


    @Override
    public void runDefaultExample() {
        // 1 ->  4  -> 7 -> 9 -> 3 -> 5 -> null
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(4);
        head.next = n1;
        ListNode n2 = new ListNode(7);
        n1.next = n2;
        ListNode n3 = new ListNode(9);
        n2.next = n3;
        ListNode n4 = new ListNode(3);
        n3.next = n4;
        n4.next = new ListNode(5);
        ListNode dummyHead = head;
        while (dummyHead != null) {
            System.out.print(dummyHead.val + "\t");
            dummyHead = dummyHead.next;
        }
        System.out.println();
        reverseLinkedList.reverseList(head);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public ListNode getNext() {
            return next;
        }
    }
}


