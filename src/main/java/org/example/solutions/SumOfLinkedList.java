package org.example.solutions;

public class SumOfLinkedList implements DefaultSolution {

    private int sumList(Node<Integer> head) {
        Node<Integer> current = head;
        int sum = 0;
        while (current != null) {
            sum += current.val;
            current = current.next;
        }
        return sum;
    }

    private int sumListRecursive(Node<Integer> head, int sum) {
        if (head == null) {
            return sum;
        }
        sum += head.val;
        return sumListRecursive(head.next, sum);
    }

    @Override
    public void runDefaultExample() {
        Node<Integer> a = new Node<>(2);
        Node<Integer> b = new Node<>(8);
        Node<Integer> c = new Node<>(3);
        Node<Integer> d = new Node<>(-1);
        Node<Integer> e = new Node<>(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        Node<Integer> x = new Node<>(38);
        Node<Integer> y = new Node<>(4);

        x.next = y;

        System.out.println(sumList(a));
        System.out.println(sumListRecursive(a, 0));
        System.out.println(sumList(x));
        System.out.println(sumListRecursive(x, 0));
        System.out.println(sumList(null));
        System.out.println(sumListRecursive(null, 0));
        System.out.println(sumList(new Node<>(100)));
        System.out.println(sumListRecursive(new Node<>(100), 0));
    }
}
