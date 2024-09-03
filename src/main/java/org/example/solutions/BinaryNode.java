package org.example.solutions;

public class BinaryNode<T> {

    T val;
    BinaryNode<T> left, right;

    public BinaryNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
