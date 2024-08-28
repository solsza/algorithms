package org.example.solutions.binarytree;

import org.example.solutions.DefaultSolution;

import java.util.Stack;

public class ValueCount implements DefaultSolution {

    private <T> int treeValueCount(Node<T> root, T target) {
        if (root == null) {
            return 0;
        }
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        int count = 0;
        while (!stack.isEmpty()) {
            Node<T> current = stack.pop();
            if (current.val == target) {
                count++;
            }
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        return count;
    }

    private <T> int treeValueCount1(Node<T> root, T target) {
        if (root == null) {
            return 0;
        }
        int match = root.val == target ? 1 : 0;
        return match + treeValueCount(root.left, target) + treeValueCount(root.right, target);
    }

    //     12
    //    /   \
    //   6     6
    //  / \     \
    // 4   6     12


    @Override
    public void runDefaultExample() {
        Node<Integer> a = new Node<>(12);
        Node<Integer> b = new Node<>(6);
        Node<Integer> c = new Node<>(6);
        Node<Integer> d = new Node<>(4);
        Node<Integer> e = new Node<>(6);
        Node<Integer> f = new Node<>(12);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        //     12
        //    /   \
        //   6     6
        //  / \     \
        // 4   6     12

        System.out.println(treeValueCount(a, 6));
    }
}
