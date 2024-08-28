package org.example.solutions.binarytree;

import org.example.solutions.DefaultSolution;

import java.util.ArrayList;
import java.util.List;

public class LevelAverages implements DefaultSolution {

    private List<Double> levelAverages(Node<Integer> root) {
        List<List<Double>> levels = new ArrayList<>();
        fillLevels(root, 0, levels);
        List<Double> averages = new ArrayList<>();
        for (List<Double> level : levels) {
            Double sum = 0.;
            for (Double val : level) {
                sum += val;
            }
            averages.add(sum / level.size());
        }
        return averages;
    }

    private void fillLevels(Node<Integer> root, int levelIdx, List<List<Double>> levels) {
        if (root == null) {
            return;
        }

        if (levelIdx == levels.size()) {
            List<Double> newLevel = new ArrayList<>();
            newLevel.add(Double.valueOf(root.val));
            levels.add(newLevel);
        } else {
            levels.get(levelIdx).add(Double.valueOf(root.val));
        }

        fillLevels(root.left, levelIdx + 1, levels);
        fillLevels(root.right, levelIdx + 1, levels);
    }

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

        System.out.println(levelAverages(a)); // -> [ 3., 7.5, 1. ]
    }
}
