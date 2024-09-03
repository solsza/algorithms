package org.example.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class LowestCommonAncestor implements DefaultSolution {

    private String lowestCommonAncestor(BinaryNode<String> root, String val1, String val2) {
        List<String> firstPath = dfs(root, val1);
        List<String> secondPath = dfs(root, val2);
        HashSet<String> set = new HashSet<>(firstPath); //dba
        for (String val : secondPath) {
            if (set.contains(val)) {
                return val;
            }
        }
        return null;
    }

    List<String> dfs(BinaryNode<String> current, String targetValue) {
        if (current == null) {
            return List.of();
        }
        if (Objects.equals(current.val, targetValue)) {
            ArrayList<String> list = new ArrayList<>();
            list.add(current.val);
            return list;
        }
        List<String> dfs = dfs(current.left, targetValue);
        if (!dfs.isEmpty()) {
            dfs.add(current.val);
            return dfs;
        }
        List<String> dfs1 = dfs(current.right, targetValue);
        if (!dfs1.isEmpty()) {
            dfs1.add(current.val);
            return dfs1;
        }
        return List.of();
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
        System.out.println(lowestCommonAncestor(a, "d", "h"));
        System.out.println(lowestCommonAncestor(a, "f", "c")); // c
    }
}
