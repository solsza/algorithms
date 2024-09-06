package org.example.solutions;

import java.util.ArrayList;
import java.util.List;

public class PostOrder implements DefaultSolution {

    private List<String> postOrder(BinaryNode<String> root) {
        List<String> values = new ArrayList<>();
        postOrder(root, values);
        return values;
    }

    private void postOrder(BinaryNode<String> root, List<String> values) {
        if (root == null) return;
        postOrder(root.left, values);
        postOrder(root.right, values);
        values.add(root.val);
    }


    @Override
    public void runDefaultExample() {
        BinaryNode<String> a = new BinaryNode<>("a");
        BinaryNode<String> b = new BinaryNode<>("b");
        BinaryNode<String> c = new BinaryNode<>("c");
        BinaryNode<String> d = new BinaryNode<>("d");
        BinaryNode<String> e = new BinaryNode<>("e");
        BinaryNode<String> f = new BinaryNode<>("f");
        BinaryNode<String> g = new BinaryNode<>("g");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        //      a
        //    /    \
        //   b      c
        //  / \    / \
        // d   e  f   g
        List<String> result = postOrder(a);
        System.out.println(result);
        // [ "d", "e", "b", "f", "g", "c", "a" ]
    }
}
