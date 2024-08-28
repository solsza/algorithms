package org.example.solutions;

public class GetNodeValue implements DefaultSolution {

    private <T> T getNodeValue(Node<T> head, int index) {
        Node<T> current = head;
        int pointer = 0;
        while (current != null) {
            if (pointer == index) {
                return current.val;
            }
            pointer++;
            current = current.next;
        }
        return null;
    }

    private <T> T getNodeValueRecursive(Node<T> head, int index, int currentIndex) {
        if (head == null) {
            return null;
        }
        if (currentIndex == index) {
            return head.val;
        }
        return getNodeValueRecursive(head.next, index, currentIndex + 1);
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
        System.out.println(getNodeValue(a, 2));
        System.out.println(getNodeValueRecursive(a, 2, 0));

        Node<String> a1 = new Node<>("a");
        Node<String> b1 = new Node<>("b");
        Node<String> c1 = new Node<>("c");
        Node<String> d1 = new Node<>("d");

        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        System.out.println(getNodeValue(a, 3));
        System.out.println(getNodeValueRecursive(a, 3, 0));

        Node<String> a2 = new Node<>("a");
        Node<String> b2 = new Node<>("b");
        Node<String> c2 = new Node<>("c");
        Node<String> d2 = new Node<>("d");

        a2.next = b2;
        b2.next = c2;
        c2.next = d2;
        System.out.println(getNodeValue(a, 7));
        System.out.println(getNodeValueRecursive(a, 7, 0));


    }
}
