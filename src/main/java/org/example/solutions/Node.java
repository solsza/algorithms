package org.example.solutions;

class Node<T> {
    T val;
    Node<T> next;

    public Node(T val) {
        this.val = val;
        this.next = null;
    }

    public static <T> void printNode(Node<T> node) {
        while (node != null) {
            System.out.print(node.val + "\t");
            node = node.next;
        }
    }
}
