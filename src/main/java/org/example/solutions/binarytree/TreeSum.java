package org.example.solutions.binarytree;

import org.example.solutions.DefaultSolution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeSum implements DefaultSolution {

    private int treeSum(Node<Integer> root) {
        if (root == null) return 0;
        int sum = 0;
        Stack<Node<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<Integer> current = stack.pop();
            sum += current.val;
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        return sum;
    }


    private int treeSum1(Node<Integer> root) {
        if (root == null) return 0;
        int sum = 0;
        Queue<Node<Integer>> queue = new LinkedList<>();  //a,b,c ->  [c,b,a] -> a,b,c
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<Integer> current = queue.poll();
            sum += current.val;
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return sum;
    }

    private int treeSum2(Node<Integer> root) {
        return treeSumRecursive(root);
    }

    private int treeSumRecursive(Node<Integer> current) {
        if (current == null) {
            return 0;
        }
        return current.val + treeSumRecursive(current.left) + treeSumRecursive(current.right);
    }
    // 3 -> 11() + 4
    // 11 -> 11 + 4 + -2
    // 4 -> 4 + 0 + 0


    //      3!             sum = 0 ->  sum = 3 ->  treeSumRecursive(current.left[11], 3)
    //    /    \            -> sum = 14   -> treeSumRecursive(current.left[4], 14)
    //  11!     4           -> sum = 18   -> treeSumRecursive(current.left[null], 18) -> sum -> 18
    //  / \      \          -> sum = 18   -> treeSumRecursive(current.right[null], 18) -> sum -> 16
    // 4!   -2     1


    @Override
    public void runDefaultExample() {
        Node<Integer> a = new Node<>(3);
        Node<Integer> b = new Node<>(11);
        Node<Integer> c = new Node<>(4);
        Node<Integer> d = new Node<>(4);
        Node<Integer> e = new Node<>(-2);
        Node<Integer> f = new Node<>(1);

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

        int i = treeSum2(a);
        System.out.println(i);

    }
}
