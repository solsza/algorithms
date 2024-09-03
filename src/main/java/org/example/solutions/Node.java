package org.example.solutions;

public class Node<T> {

    T val;
    Node<T> next;

    public Node(T val) {
        this.val = val;
        this.next = null;
    }

    public Node(T val, Node<T> next) {
        this.val = val;
        this.next = next;
    }

    public static <T> void printNode(Node<T> node) {
        System.out.println();
        while (node != null) {
            System.out.print(node.val + "\t");
            node = node.next;
        }
        System.out.println();
    }
}
