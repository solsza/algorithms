package org.example.solutions;

public class MergeTwoSortedLists implements DefaultSolution {


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }

        cur.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }

    public void runDefaultExample() {

        //L1 = [1,2,4]
        ListNode l1_2 = new ListNode(4);
        ListNode l1_1 = new ListNode(2, l1_2);
        ListNode l1 = new ListNode(1, l1_1);

        //L2 = [1,3,4]
        ListNode l2_2 = new ListNode(4);
        ListNode l2_1 = new ListNode(3, l2_2);
        ListNode l2 = new ListNode(1, l2_1);

        ListNode listNode = mergeTwoLists(l1, l2);
        StringBuilder valueToPrint = new StringBuilder();
        while (listNode.next != null) {
            valueToPrint.append(listNode.val).append(" ");
            listNode = listNode.next;
        }
        System.out.println(valueToPrint.toString());


    }

    public class ListNode {
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
