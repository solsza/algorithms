package org.example.solutions.binarytree;

import org.example.solutions.DefaultSolution;

import java.util.LinkedList;
import java.util.Queue;

public class MinValue implements DefaultSolution {

    private Double treeMinValue(Node<Double> root) {
        if (root == null) return null;
        Queue<Node<Double>> queue = new LinkedList<>();
        queue.add(root);
        double min = root.val;
        while (!queue.isEmpty()) {
            Node<Double> current = queue.poll();
            if (current.val < min) {
                min = current.val;
            }
            current.val = min;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return min;
    }

    private Double treeMinValue1(Node<Double> root) {
        if (root == null) return Double.POSITIVE_INFINITY;
        double min = Math.min(treeMinValue1(root.left), treeMinValue1(root.right));
        return Math.min(min, root.val);
    }

    //       3
    //    /    \
    //   11     4
    //  / \      \
    // 4   -2     1
    // inf  inf   inf


    @Override
    public void runDefaultExample() {
        Node<Double> a = new Node<>(3.);
        Node<Double> b = new Node<>(11.);
        Node<Double> c = new Node<>(4.);
        Node<Double> d = new Node<>(4.);
        Node<Double> e = new Node<>(-2.);
        Node<Double> f = new Node<>(1.);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        //       3
        //    /    \
        //   11     4
        //  / \      \
        // 4   -2     1

        System.out.println(treeMinValue(a)); // -> -2

        Node<Double> a1 = new Node<>(5.);
        Node<Double> b1 = new Node<>(11.);
        Node<Double> c1 = new Node<>(3.);
        Node<Double> d1 = new Node<>(4.);
        Node<Double> e1 = new Node<>(14.);
        Node<Double> f1 = new Node<>(12.);

        a1.left = b1;
        a1.right = c1;
        b1.left = d1;
        b1.right = e1;
        c1.right = f1;

        //       5
        //    /    \
        //   11     3
        //  / \      \
        // 4   14     12

        System.out.println(treeMinValue(a1)); // -> 3
    }
}
