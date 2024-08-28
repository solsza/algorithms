package org.example.solutions.binarytree;

public class Node<T> {

    T val;
    Node<T> left, right;

    public Node(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
