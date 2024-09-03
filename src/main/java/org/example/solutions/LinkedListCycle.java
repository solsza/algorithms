package org.example.solutions;

import java.util.HashSet;

public class LinkedListCycle implements DefaultSolution {

    private <T> boolean linkedListCycle(Node<T> head) {
        HashSet<T> visitedNodes = new HashSet<>();
        Node<T> current = head;
        while (current != null) {
            if (visitedNodes.contains(current.val)) {
                return true;
            }
            visitedNodes.add(current.val);
            current = current.next;
        }
        return false;
    }

    private <T> boolean linkedListCycle1(Node<T> head) {
        Node<T> slow = head;
        Node<T> fast = head;
        boolean firstIteration = true;
        while (fast != null && fast.next != null) {
            if (slow == fast && !firstIteration) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
            firstIteration = false;
        }
        return false;
    }

    @Override
    public void runDefaultExample() {
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b; // cycle
        //         _______
        //       /        \
        // a -> b -> c -> d
        System.out.println(linkedListCycle(a));  // true
    }
}
