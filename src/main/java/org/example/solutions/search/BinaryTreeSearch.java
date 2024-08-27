package org.example.solutions.search;

import java.text.MessageFormat;
import java.util.Optional;
import org.example.solutions.DefaultSolution;

public class BinaryTreeSearch implements DefaultSolution {

    public Node search(Node root, int key) {
        if (root == null || root.value == key) {
            return root;
        }

        if (root.value > key) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    class Node {

        int value;
        Node left, right;

        public Node(int item) {
            value = item;
            left = right = null;
        }
    }

    @Override
    public void runDefaultExample() {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        Node search = search(root, 5);
        if (search != null) {
            System.out.println(MessageFormat.format("Node value : {0} , node left child value {1}, node right child value {2}",
                search.value, Optional.ofNullable(search.left).map(node -> node.value).orElse(null),
                Optional.ofNullable(search.right).map(node -> node.value).orElse(null)));
        } else {
            System.out.println("Node not found");
        }
    }
}
