package org.example.solutions;

import static org.example.solutions.Node.printNode;

public class RemoveNode implements DefaultSolution {

    private <T> Node<T> removeNode(Node<T> head, T targetVal) {
        if (head.val == targetVal) {
            return head.next;
        }
        Node<T> prev = null;
        Node<T> current = head;
        while (current != null) {
            if (current.val == targetVal) {
                prev.next = current.next;
                break;
            }
            prev = current;
            current = current.next;
        }
        return head;
    }

    private <T> Node<T> removeNodeRecursive(Node<T> head, T targetVal) {
        if (head.val == targetVal) {
            return head.next;
        }

        head.next = removeNodeRecursive(head.next, targetVal);
        return head;
    }


    @Override
    public void runDefaultExample() {
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        // a -> b -> c -> d -> e -> f

        printNode(removeNode(a, "c"));
        // a -> b -> d -> e -> f


        Node<String> x = new Node<>("x");
        Node<String> y = new Node<>("y");
        Node<String> z = new Node<>("z");

        x.next = y;
        y.next = z;

        // x -> y -> z
        System.out.println();
        printNode(removeNode(x, "z"));
        // x -> y
    }
}
