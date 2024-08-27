package org.example.solutions;

import static org.example.solutions.Node.printNode;

public class MergeTwoSortedLists implements DefaultSolution {

    private Node<Integer> mergeLists(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> head;
        Node<Integer> current1 = head1;
        Node<Integer> current2 = head2;
        if (head1.val > head2.val) {
            head = head2;
            current2 = head2.next;
        } else {
            head = head1;
            current1 = head1.next;
        }

        Node<Integer> tail = head;
        while (current1 != null && current2 != null) {
            if(current1.val < current2.val) {
                tail.next = current1;
                current1 = current1.next;
            }
            else {
                tail.next = current2;
                current2 = current2.next;
            }
            tail = tail.next;
        }
        if (current1 != null) {
            tail.next = current1;
        }
        if (current2 != null) {
            tail.next = current2;
        }
        return head;
    }

    private Node<Integer> mergeListWithDummyHead(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> dummyHead = new Node<>(0);
        Node<Integer> tail = dummyHead;
        Node<Integer> current1 = head1;
        Node<Integer> current2 = head2;
        while (current1 != null && current2 != null) {
            if(current1.val < current2.val) {
                tail.next = current1;
                current1 = current1.next;
            }
            else {
                tail.next = current2;
                current2 = current2.next;
            }
            tail = tail.next;
        }
        if (current1 != null) {
            tail.next = current1;
        }
        if (current2 != null) {
            tail.next = current2;
        }
        return dummyHead.next;
    }

    @Override
    public void runDefaultExample() {
        Node<Integer> a = new Node<>(5);
        Node<Integer> b = new Node<>(7);
        Node<Integer> c = new Node<>(10);
        Node<Integer> d = new Node<>(12);
        Node<Integer> e = new Node<>(20);
        Node<Integer> f = new Node<>(28);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        // 5 -> 7 -> 10 -> 12 -> 20 -> 28

        Node<Integer> q = new Node<>(6);
        Node<Integer> r = new Node<>(8);
        Node<Integer> s = new Node<>(9);
        Node<Integer> t = new Node<>(25);
        q.next = r;
        r.next = s;
        s.next = t;
        // 6 -> 8 -> 9 -> 25
        printNode(mergeLists(a, q));
    }
}
