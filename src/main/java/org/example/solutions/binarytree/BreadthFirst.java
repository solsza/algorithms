package org.example.solutions.binarytree;

import org.example.solutions.DefaultSolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirst implements DefaultSolution {

    private List<String> breadthFirstValues(Node<String> root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<Node<String>> queue = new LinkedList<>();
        queue.add(root);
        List<String> values = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node<String> current = queue.poll();
            values.add(current.val);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return values;
    }

    @Override
    public void runDefaultExample() {
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        //      a!                      [a]         ->
        //    /   \
        //   b     c                   [c , b] ->
        //  / \     \
        // d   e     f                [d,e,c]

        System.out.println(breadthFirstValues(a));
        //    -> ["a", "b", "c", "d", "e", "f"]
    }
}
