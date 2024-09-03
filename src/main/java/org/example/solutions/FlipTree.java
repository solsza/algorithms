package org.example.solutions;

public class FlipTree implements DefaultSolution {

    private BinaryNode<String> flipTree(BinaryNode<String> root) {
        if (root == null) {
            return null;
        }
        System.out.println(root.val);
        if (root.left == null && root.right == null) {
            return root;
        }
        BinaryNode<String> rightNode = flipTree(root.right);
        BinaryNode<String> leftNode = flipTree(root.left);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }


    @Override
    public void runDefaultExample() {
        BinaryNode<String> n = new BinaryNode<>("n");
        BinaryNode<String> y = new BinaryNode<>("y");
        BinaryNode<String> c = new BinaryNode<>("c");
        n.left = y;
        n.right = c;

        //       n
        //     /   \
        //    y     c
        BinaryNode<String> stringBinaryNode = flipTree(n);
        //       n
        //     /   \
        //    c     y

        BinaryNode<String> l1 = new BinaryNode<>("l");
        BinaryNode<String> m1 = new BinaryNode<>("m");
        BinaryNode<String> n1 = new BinaryNode<>("n");
        BinaryNode<String> o1 = new BinaryNode<>("o");
        BinaryNode<String> p1 = new BinaryNode<>("p");
        BinaryNode<String> q1 = new BinaryNode<>("q");
        BinaryNode<String> r1 = new BinaryNode<>("r");
        BinaryNode<String> s1 = new BinaryNode<>("s");
        BinaryNode<String> t1 = new BinaryNode<>("t");

        l1.left = m1;
        l1.right = n1;
        n1.left = o1;
        n1.right = p1;
        o1.left = q1;
        o1.right = r1;
        p1.left = s1;
        p1.right = t1;

        //        l
        //     /     \
        //    m       n
        //         /    \
        //         o     p
        //        / \   / \
        //       q   r s   t

        BinaryNode<String> stringBinaryNode1 = flipTree(l1);
        stringBinaryNode1.left = stringBinaryNode;

        //             l
        //         /      \
        //        n        m
        //      /  \
        //    p     o
        //  / \    / \
        // t   s  r   q
    }
}
