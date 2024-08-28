package org.example.solutions.binarytree;

import org.example.solutions.DefaultSolution;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class TreeLevels implements DefaultSolution {

    private <T> List<List<T>> treeLevels(Node<T> root) {
        if (root == null) {
            return List.of();
        }
        List<List<T>> levels = new ArrayList<>();
        ArrayDeque<SimpleEntry<Node<T>, Integer>> queue = new ArrayDeque<>();
        queue.add(new SimpleEntry<>(root, 0));
        while (!queue.isEmpty()) {
            SimpleEntry<Node<T>, Integer> pair = queue.remove();
            Node<T> node = pair.getKey();
            int level = pair.getValue();

            if (level == levels.size()) {
                ArrayList<T> newList = new ArrayList<>();
                newList.add(node.val);
                levels.add(newList);
            } else {
                levels.get(level).add(node.val);
            }
            if (node.left != null) {
                queue.add(new SimpleEntry<>(node.left, level + 1));
            }
            if (node.right != null) {
                queue.add(new SimpleEntry<>(node.right, level + 1));
            }
        }

        return levels;
    }

    public static <T> List<List<T>> treeLevels1(Node<T> root) {
        if (root == null) {
            return List.of();
        }
        List<List<T>> levels = new ArrayList<>();
        ArrayDeque<SimpleEntry<Node<T>, Integer>> queue = new ArrayDeque<>();
        queue.add(new SimpleEntry<>(root, 0));
        while (!queue.isEmpty()) {
            SimpleEntry<Node<T>, Integer> pair = queue.remove();
            Node<T> node = pair.getKey();
            int level = pair.getValue();

            if (level == levels.size()) {
                ArrayList<T> newList = new ArrayList<>();
                newList.add(node.val);
                levels.add(newList);
            } else {
                levels.get(level).add(node.val);
            }

            if (node.left != null) {
                queue.add(new SimpleEntry<>(node.left, level + 1));
            }
            if (node.right != null) {
                queue.add(new SimpleEntry<>(node.right, level + 1));
            }
        }

        return levels;
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
        Node<String> i = new Node<>("i");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        e.right = h;
        f.left = i;

        //         a
        //      /    \
        //     b      c
        //   /  \      \
        //  d    e      f
        //      / \    /
        //     g  h   i

        System.out.println(treeLevels(a));

        // [
        //   ['a'],
        //   ['b', 'c'],
        //   ['d', 'e', 'f'],
        //   ['g', 'h', 'i']
        // ]
    }
}
