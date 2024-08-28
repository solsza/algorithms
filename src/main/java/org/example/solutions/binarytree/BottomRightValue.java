package org.example.solutions.binarytree;

import org.example.solutions.DefaultSolution;

import java.util.LinkedList;
import java.util.Queue;

public class BottomRightValue implements DefaultSolution {

    private <T> T bottomRightValue(Node<T> root) {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        Node<T> current = null;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return current.val;
    }

    @Override
    public void runDefaultExample() {

    }
}
