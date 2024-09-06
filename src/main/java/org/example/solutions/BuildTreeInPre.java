package org.example.solutions;

import java.util.List;

public class BuildTreeInPre implements DefaultSolution {

    private BinaryNode<String> buildTreeInPre(List<String> inOrder, List<String> preOrder) {
        if (inOrder.isEmpty()) return null;

        String value = preOrder.get(0);
        BinaryNode<String> root = new BinaryNode<>(value);

        int midIdx = inOrder.indexOf(value);
        List<String> leftIn = inOrder.subList(0, midIdx);
        List<String> rightIn = inOrder.subList(midIdx + 1, inOrder.size());

        List<String> leftPre = preOrder.subList(1, leftIn.size() + 1);
        List<String> rightPre = preOrder.subList(leftIn.size() + 1, preOrder.size());

        root.left = buildTreeInPre(leftIn, leftPre);
        root.right = buildTreeInPre(rightIn, rightPre);
        return root;
    }

    @Override
    public void runDefaultExample() {
        BinaryNode<String> stringBinaryNode = buildTreeInPre(
                List.of("d", "b", "g", "e", "h", "a", "c", "f"),
                List.of("a", "b", "d", "e", "g", "h", "c", "f")
        );
        System.out.println(stringBinaryNode);
        //       a
        //    /    \
        //   b      c
        //  / \      \
        // d   e      f
        //    / \
        //    g  h
    }
}
