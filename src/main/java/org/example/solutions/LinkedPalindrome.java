package org.example.solutions;

import java.util.ArrayList;
import java.util.List;

public class LinkedPalindrome implements DefaultSolution {

    private <T> boolean linkedPalindrome(Node<T> head) {
        if (head == null || head.next == null) return true;
        List<T> values = new ArrayList<T>();
        Node<T> current = head;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
        int i = 0;
        int j = values.size() - 1;
        while (i < j) {
            if (!values.get(i).equals(values.get(j))) return false;
            i++;
            j--;
        }
        return true;
    }


    @Override
    public void runDefaultExample() {
        Node<Integer> a = new Node<>(3);
        Node<Integer> b = new Node<>(2);
        Node<Integer> c = new Node<>(7);
        Node<Integer> d = new Node<>(7);
        Node<Integer> e = new Node<>(2);
        Node<Integer> f = new Node<>(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        // 3 -> 2 -> 7 -> 7 -> 2 -> 3
        System.out.println(linkedPalindrome(a)); // true
        Node<Integer> a1 = new Node<>(5);
        System.out.println(linkedPalindrome(a1)); // true
    }
}
