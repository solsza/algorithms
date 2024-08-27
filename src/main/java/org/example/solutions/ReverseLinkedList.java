package org.example.solutions;

public class ReverseLinkedList implements DefaultSolution {

    private <T> Node<T> reverseList(Node<T> head) {
        Node<T> previous = null;
        Node<T> current = head;
        Node<T> next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    private <T> Node<T> reverseListRecursive(Node<T> previous, Node<T> head) {
        if(head == null) {
            return previous;
        }
        Node<T> next = head.next;
        head.next = previous;
        return reverseListRecursive(head, next);
    }

    @Override
    public void runDefaultExample() {
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

//        System.out.println(reverseList(a));
        System.out.println(reverseListRecursive(null, a));
    }
}


