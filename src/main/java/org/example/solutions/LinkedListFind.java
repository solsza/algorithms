package org.example.solutions;

public class LinkedListFind implements DefaultSolution{

    private <T> boolean linkedListFind(Node<T> head, T target) {
        Node<T> current = head;
        while (current != null) {
            if(current.val == target) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private <T> boolean linkedListFindRecursive(Node<T> head, T target) {
        if (head == null) {
            return false;
        }
        if(head.val == target) {
            return true;
        }
        return linkedListFindRecursive(head.next, target);
    }


    @Override
    public void runDefaultExample() {
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");

        a.next = b;
        b.next = c;
        c.next = d;
        System.out.println(linkedListFind(a,"c"));
        System.out.println(linkedListFindRecursive(a,"c"));
        System.out.println();

        Node<String> a1 = new Node<>("a");
        Node<String> b1 = new Node<>("b");
        Node<String> c1 = new Node<>("c");
        Node<String> d1 = new Node<>("d");

        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        System.out.println(linkedListFind(a,"q"));
        System.out.println(linkedListFindRecursive(a,"q"));
        System.out.println();

        Node<Integer> node1 = new Node<>(42);
        System.out.println(linkedListFind(node1, 42));
        System.out.println(linkedListFindRecursive(node1, 42));
        System.out.println();
    }
}
