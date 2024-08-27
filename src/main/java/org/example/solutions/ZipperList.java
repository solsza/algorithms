package org.example.solutions;

import static org.example.solutions.Node.printNode;

public class ZipperList implements DefaultSolution {

    private <T> Node<T> zipperLists(Node<T> head1, Node<T> head2) {
        Node<T> head = head1;
        Node<T> tail = head;
        Node<T> current1 = head1.next;
        Node<T> current2 = head2;
        int count = 0;

        while (current1 != null && current2 != null) {
            if (count % 2 == 0) {
                tail.next = current2;
                current2 = current2.next;
            } else {
                tail.next = current1;
                current1 = current1.next;
            }
            tail = tail.next;
            count += 1;
        }

        if (current1 != null) {
            tail.next = current1;
        }
        if (current2 != null) {
            tail.next = current2;
        }

        return head;
    }

    private <T> Node<T> zipperLists2(Node<T> head1, Node<T> head2) {
        return zipperListsRecursive(head1, head2, 0);
    }

    private <T> Node<T> zipperListsRecursive(Node<T> head1, Node<T> head2, int counter) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (counter % 2 == 0) {
            head1.next = zipperListsRecursive(head1.next, head2, counter + 1);
            return head1;
        } else {
            head2.next = zipperListsRecursive(head1, head2.next, counter + 1);
            return head2;
        }
    }


    @Override
    public void runDefaultExample() {
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        a.next = b;
        b.next = c;

        Node<String> x = new Node<>("x");
        Node<String> y = new Node<>("y");
        Node<String> z = new Node<>("z");
        x.next = y;
        y.next = z;
        printNode(zipperLists2(a, x));

        Node<String> a1 = new Node<>("a");
        Node<String> b1 = new Node<>("b");
        Node<String> c1 = new Node<>("c");
        a1.next = b1;
        b1.next = c1;
        Node<String> x1 = new Node<>("x");
        Node<String> y1 = new Node<>("y");
        Node<String> z1 = new Node<>("z");
        x1.next = y1;
        y1.next = z1;
        Node<String> stringNode = zipperLists(a1, x1);
        System.out.println();
        printNode(stringNode);

    }
    //                 c1
    //  a -> b -> c -> w -> t -> u
    //  x -> y -> z
    //                 c2

    //   a  ->  x -> b -> y -> c -> z -> null
    //  head
    //                             tail
}
