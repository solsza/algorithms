package org.example.solutions;

import java.util.List;

public class BuildingTreeInPost implements DefaultSolution {

    private BinaryNode<String> buildTreeInPost(List<String> inOrder, List<String> postOrder) {
        if (inOrder.isEmpty()) return null;
        String currentValue = postOrder.get(postOrder.size() - 1);
        BinaryNode<String> root = new BinaryNode<>(postOrder.get(postOrder.size() - 1));
        int midIdx = inOrder.indexOf(currentValue);

        List<String> leftInOrder = inOrder.subList(0, midIdx);
        List<String> rightInOrder = inOrder.subList(midIdx + 1, inOrder.size());

        List<String> leftPost = postOrder.subList(0, leftInOrder.size());
        List<String> rightPost = postOrder.subList(rightInOrder.size(), postOrder.size() - 1);

        root.left = buildTreeInPost(leftInOrder, leftPost);
        root.right = buildTreeInPost(rightInOrder, rightPost);
        return root;
    }


    @Override
    public void runDefaultExample() {
        System.out.println(buildTreeInPost(
                List.of("d", "b", "e", "a", "f", "c", "g"),
                List.of("d", "e", "b", "f", "g", "c", "a")
        ));
        //      a
        //    /    \
        //   b      c
        //  / \    / \
        // d   e  f   g
    }
}
