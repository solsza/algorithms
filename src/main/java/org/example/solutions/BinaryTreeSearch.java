package org.example.solutions;

public class BinaryTreeSearch implements DefaultSolution {

    private boolean binarySearchTreeIncludes(BinaryNode<Integer> root, int target) {
        if (root == null) return false;
        if (target < root.val) {
            return binarySearchTreeIncludes(root.left, target);
        } else if (target > root.val) {
            return binarySearchTreeIncludes(root.right, target);
        } else {
            return true;
        }
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
    }
}
