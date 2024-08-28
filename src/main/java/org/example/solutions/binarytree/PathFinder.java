package org.example.solutions.binarytree;

import org.example.solutions.DefaultSolution;

import java.util.ArrayList;
import java.util.List;

public class PathFinder implements DefaultSolution {

    private <T> List<T> pathFinder(Node<T> root, T target) {
        List<T> result = pathFinderRecursive(root, target);
        return result == null ? null : result.reversed();

    }

    private <T> List<T> pathFinderRecursive(Node<T> root, T target) {
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            ArrayList<T> list = new ArrayList<>();
            list.add(target);
            return list;
        }
        List<T> leftPath = pathFinderRecursive(root.left, target);
        if (leftPath != null) {
            leftPath.add(root.val);
            return leftPath;
        }

        //      a
        //    /   \
        //   b     c
        //  / \     \
        // d   e     f

        List<T> rightPath = pathFinderRecursive(root.right, target);
        if (rightPath != null) {
            rightPath.add(root.val);
            return rightPath;
        }
        return null;
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

        //      a
        //    /   \
        //   b     c
        //  / \     \
        // d   e     f

        System.out.println(pathFinder(a, "e")); // -> [ "a", "b", "e" ]
    }
}
