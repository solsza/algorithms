package org.example.solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import static java.util.AbstractMap.SimpleEntry;

public class LeftyNodes implements DefaultSolution {

    private List<String> leftyNodes(BinaryNode<String> root) {
        if (root == null) return List.of();
        int counter = 0;
        List<String> result = new ArrayList<>();
        ArrayDeque<SimpleEntry<BinaryNode<String>, Integer>> queue = new ArrayDeque<>();
        queue.add(new SimpleEntry<>(root, counter));
        while (!queue.isEmpty()) {
            SimpleEntry<BinaryNode<String>, Integer> current = queue.remove();
            BinaryNode<String> currentNode = current.getKey();
            Integer level = current.getValue();
            if (counter == level) {
                result.add(currentNode.val);
                counter++;
            }
            if (currentNode.left != null) {
                queue.add(new SimpleEntry<>(currentNode.left, counter));
            }
            if (currentNode.right != null) {
                queue.add(new SimpleEntry<>(currentNode.right, counter));
            }

        }
        return result;
    }

    private List<String> leftyNodes1(BinaryNode<String> root) {
        List<String> values = new ArrayList<>();
        traverse(root, values, 0);
        return values;
    }

    private void traverse(BinaryNode<String> root, List<String> values, int level) {
        if (root == null) return;
        if (level == values.size()) values.add(root.val);
        traverse(root.left, values, level + 1);
        traverse(root.right, values, level + 1);
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
        BinaryNode<String> h = new BinaryNode<>("h");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        e.right = h;

        //      a
        //    /    \
        //   b      c
        //  / \      \
        // d   e      f
        //    / \
        //    g  h

        System.out.println(leftyNodes(a)); // [ "a", "b", "d", "g" ]

        BinaryNode<String> i = new BinaryNode<>("i");
        BinaryNode<String> n = new BinaryNode<>("n");
        BinaryNode<String> s = new BinaryNode<>("s");
        BinaryNode<String> t = new BinaryNode<>("t");

        i.right = n;
        n.left = s;
        n.right = t;

        //       i
        //        \
        //         n
        //        / \
        //       s   t

        System.out.println(leftyNodes(i)); // [ "i", "n", "s" ]
        System.out.println(leftyNodes(null)); // [ ]
    }
}
