package org.example.solutions;

import java.util.ArrayList;
import java.util.List;

public class IsBinarySearchTree implements DefaultSolution {

    private boolean isBinarySearchTree(BinaryNode<Integer> root) {
        List<Integer> values = new ArrayList<>();
        inOrderTraversal(root, values);
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i) > values.get(i + 1)) return false;
        }
        return true;
    }

    private void inOrderTraversal(BinaryNode<Integer> root, List<Integer> values) {
        if (root == null) return;
        inOrderTraversal(root.left, values);
        values.add(root.val);
        inOrderTraversal(root.right, values);
    }


    @Override
    public void runDefaultExample() {
        BinaryNode<Integer> a = new BinaryNode<>(12);
        BinaryNode<Integer> b = new BinaryNode<>(5);
        BinaryNode<Integer> c = new BinaryNode<>(18);
        BinaryNode<Integer> d = new BinaryNode<>(3);
        BinaryNode<Integer> e = new BinaryNode<>(9);
        BinaryNode<Integer> f = new BinaryNode<>(19);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        //      12
        //    /   \
        //   5     18
        //  / \     \
        // 3   9     19
        System.out.println(isBinarySearchTree(a)); // -> true
    }
}
