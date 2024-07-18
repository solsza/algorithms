package org.example.solutions;

public class AddTwoNumbers implements DefaultSolution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }

    public void runDefaultExample() {
        // 9 -> 9 -> 9 -> 9 -> 9 -> 9 -> 9
        ListNode l1_6 = new ListNode(9);
        ListNode l1_5 = new ListNode(9, l1_6);
        ListNode l1_4 = new ListNode(9, l1_5);
        ListNode l1_3 = new ListNode(9, l1_4);
        ListNode l1_2 = new ListNode(9, l1_3);
        ListNode l1_1 = new ListNode(9, l1_2);
        ListNode l1 = new ListNode(9, l1_1);
        // 9 -> 9 -> 9 -> 9
        ListNode l2_3 = new ListNode(9);
        ListNode l2_2 = new ListNode(9, l2_3);
        ListNode l2_1 = new ListNode(9, l2_2);
        ListNode l2 = new ListNode(9, l2_1);
        System.out.println(addTwoNumbers(l1, l2));
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
    }
}


