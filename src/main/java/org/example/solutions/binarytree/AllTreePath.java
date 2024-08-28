package org.example.solutions.binarytree;

import org.example.solutions.DefaultSolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllTreePath implements DefaultSolution {

    private <T> List<List<T>> allTreePaths(Node<T> root) {
        List<List<T>> lists = allTreePathsRecursive(root);
        for (List<T> paths : lists) {
            Collections.reverse(paths);
        }
        return lists;
    }

    private <T> List<List<T>> allTreePathsRecursive(Node<T> root) {
        if (root == null) {
            return List.of();
        }
        if (root.left == null && root.right == null) {
            List<T> path = new ArrayList<>();
            path.add(root.val);
            return List.of(path);
        }
        List<List<T>> allPaths = new ArrayList<>();
        List<List<T>> leftPaths = allTreePathsRecursive(root.left);
        for (List<T> path : leftPaths) {
            path.add(root.val);
            allPaths.add(path);
        }
        List<List<T>> rightPaths = allTreePathsRecursive(root.right);
        for (List<T> path : rightPaths) {
            path.add(root.val);
            allPaths.add(path);
        }
        return allPaths;
    }

    //      a
    //    /   \
    //   b     c
    //  / \     \
    // d   e     f


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

        System.out.println(allTreePaths(a)); // ->
        // [
        //   [ 'a', 'b', 'd' ],
        //   [ 'a', 'b', 'e' ],
        //   [ 'a', 'c', 'f' ]
        // ]
    }
}
