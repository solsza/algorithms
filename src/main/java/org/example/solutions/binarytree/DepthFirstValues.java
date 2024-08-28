package org.example.solutions.binarytree;

import org.example.solutions.DefaultSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstValues implements DefaultSolution {

    private List<String> depthFirstValues(Node<String> root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<Node<String>> stack = new Stack<>();
        stack.push(root);
        List<String> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            Node<String> current = stack.pop();
            result.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return result;
    }

    private List<String> depthFirstValues1(Node<String> root) {
        return depthFirstRecursive(root, new ArrayList<>());
    }

    private List<String> depthFirstRecursive(Node<String> current, List<String> values) {
        if (current == null) {
            return values;
        }
        values.add(current.val);
        depthFirstRecursive(current.left, values);
        depthFirstRecursive(current.right, values);
        return values;
    }

    //first iteration -> [a]
    //depthFirstRecursive(current.left, values) -> b, [a]    -> [a,b,d,e]                                                           depthFirstRecursive(current.right[c], values[a,b,d,e])   -> the same like on the left but in that case we have only righNodes
    //                                                                                                                                 -> [a,b,d,e,c f]


    //[a,b] depthFirstRecursive(current.left, values) -> d              depthFirstRecursive(current.righ [e], [a,b,d])
    // -> [a,b,d]                                                       // -> [a,b,d,e]


    private List<String> depthFirstValues3(Node<String> root) {
        if (root == null) {
            return List.of();
        }
        List<String> result = new ArrayList<>();
        result.add(root.val);
        result.addAll(depthFirstValues3(root.left));
        result.addAll(depthFirstValues3(root.left));
        return result;
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
        System.out.println(depthFirstValues(a));
//    -> ["a", "b", "d", "e", "c", "f"]

    }
}
