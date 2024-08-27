package org.example.solutions;

public class IsUnivalueList implements DefaultSolution {

    private <T> boolean isUnivalueList(Node<T> head) {
        T firstValue = head.val;
        Node<T> current = head.next;
        while (current != null) {
            if (!current.val.equals(firstValue)) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    private <T> boolean isUnivalueList2(Node<T> head) {
        return isUnivalueListRecursive(head.next, head.val);
    }

    private <T> boolean isUnivalueListRecursive(Node<T> head, T firstValue) {
        if (head == null) {
            return true;
        }
        if (head.val.equals(firstValue)) {
            return isUnivalueListRecursive(head.next, firstValue);
        } else {
            return false;
        }
    }


    @Override
    public void runDefaultExample() {
        Node<Integer> a = new Node<>(7);
        Node<Integer> b = new Node<>(7);
        Node<Integer> c = new Node<>(7);

        a.next = b;
        b.next = c;

        // 7 -> 7 -> 7
        System.out.println(isUnivalueList(a));
        System.out.println(isUnivalueList2(a));

        Node<Integer> a1 = new Node<>(7);
        Node<Integer> b1 = new Node<>(7);
        Node<Integer> c1 = new Node<>(4);

        a1.next = b1;
        b1.next = c1;

        // 7 -> 7 -> 4

        System.out.println(isUnivalueList(a1));
        System.out.println(isUnivalueList2(a1));
    }
}
