package org.example.solutions.binarytree;

import org.example.solutions.DefaultSolution;

import java.util.LinkedList;
import java.util.Queue;

public class TreeIncludes implements DefaultSolution {

    private boolean treeIncludes(Node<String> root, String target) {
        if (root == null) return false;
        Queue<Node<String>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node<String> current = q.poll();
            if (current.val.equals(target)) return true;
            if (current.left != null) q.add(current.left);
            if (current.right != null) q.add(current.right);
        }
        return false;
    }

    private boolean treeIncludes1(Node<String> root, String target) {
        if (root == null) return false;
        if (root.val.equals(target)) return true;
        return treeIncludes1(root.left, target) || treeIncludes1(root.right, target);
    }


    @Override
    public void runDefaultExample() {
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");
        Node<String> g = new Node<>("g");
        Node<String> h = new Node<>("h");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        f.right = h;

//      a
//    /   \
//   b     c
//  / \     \
// d   e     f
//    /       \
//   g         h

        System.out.println(treeIncludes(a, "p")); // -> false
        System.out.println(treeIncludes(null, "p")); // -> false

        Node<String> a1 = new Node<>("a");
        Node<String> b1 = new Node<>("b");
        Node<String> c1 = new Node<>("c");
        Node<String> d1 = new Node<>("d");
        Node<String> e1 = new Node<>("e");
        Node<String> f1 = new Node<>("f");

        a1.left = b1;
        a1.right = c1;
        b1.left = d1;
        b1.right = e1;
        c1.right = f1;

//      a
//    /   \
//   b     c
//  / \     \
// d   e     f

        System.out.println(treeIncludes(a, "a")); // -> true

    }
}
