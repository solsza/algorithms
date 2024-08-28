package org.example.solutions;

import static org.example.solutions.Node.printNode;

public class AddNodeLists implements DefaultSolution {

    public static Node<Integer> addLists(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> dummyHead = new Node<>(0);
        Node<Integer> tail = dummyHead;
        Node<Integer> counter1 = head1;
        Node<Integer> counter2 = head2;
        int carry = 0;

        while (counter1 != null || counter2 != null || carry > 0) {
            int val1 = counter1 == null ? 0 : counter1.val;
            int val2 = counter2 == null ? 0 : counter2.val;
            int sum  = val1 + val2 + carry;
            int digit = sum % 10;
            carry = sum >= 10 ? 1 : 0;
            tail.next = new Node<>(digit);
            tail = tail.next;
            if(counter1 != null) counter1 = counter1.next;
            if(counter2 != null) counter2 = counter2.next;
        }
        return dummyHead.next;
    }

    @Override
    public void runDefaultExample() {
        Node<Integer> a1 = new Node<>(1);
        Node<Integer> a2 = new Node<>(2);
        Node<Integer> a3 = new Node<>(6);
        a1.next = a2;
        a2.next = a3;
        // 1 -> 2 -> 6

        Node<Integer> b1 = new Node<>(4);
        Node<Integer> b2 = new Node<>(5);
        Node<Integer> b3 = new Node<>(3);
        b1.next = b2;
        b2.next = b3;
        // 4 -> 5 -> 3
        printNode(addLists(a1, b1));
    }
}
