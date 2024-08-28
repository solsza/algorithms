package org.example.solutions;

import static org.example.solutions.Node.printNode;

public class InsertNode implements DefaultSolution {

    private <T> Node<T> insertNode(Node<T> head, T value, int index) {
        if (index == 0) {
            return new Node<>(value, head);
        }
        Node<T> current = head.next;
        int counter = 1;
        while (counter <= index - 1) {
            if (counter == index - 1) {
                Node<T> nextNode = current.next;
                current.next = new Node<>(value, nextNode);
            } else {
                current = current.next;
            }
            counter++;
        }
        return head;
    }

    private <T> Node<T> insertNode(Node<T> head, Node<T> prev, T value, int index) {
        if (index == 0) {
            Node<T> newNode = new Node<>(value);
            newNode.next = head;
            if (prev != null) {
                prev.next = newNode;
            }
            return newNode;
        }
        head.next = insertNode(head.next, head, value, index - 1);
        return head;
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

        // a -> b -> c -> d
        System.out.println();
        printNode(insertNode(a, "x", 2));
        // a -> b -> x -> c -> d
    }
}
