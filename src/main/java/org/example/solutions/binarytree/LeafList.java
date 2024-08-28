package org.example.solutions.binarytree;

import org.example.solutions.DefaultSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeafList implements DefaultSolution {

    private static <T> List<T> leafList(Node<T> root) {
        if (root == null) return null;
        List<T> result = new ArrayList<T>();
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<T> current = stack.pop();
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
            if (current.left == null && current.right == null) {
                result.add(current.val);
            }
        }
        return result;
    }

    //      a
    //    /   \
    //   b     c
    //  / \     \
    // d   e     f
    //

    //       5          S : 54,11               Result: [20,1,3,54]
    //     /    \       S : 54, 15, 20 -> 11
    //    11    54      S : 54, 15 -> 20 -> 11
    //  /   \           S : 54,3 ,1 -> 15 -> 20 -> 11
    // 20   15          S : 54,3 -> 1 -> 15 -> 20 -> 11
    //      / \
    //     1  3         S

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

        System.out.println(leafList(a)); // -> [ "d", "e", "f" ]
    }
}
