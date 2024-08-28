package org.example.solutions;

import static org.example.solutions.Node.printNode;

import java.util.List;

public class CreateList implements DefaultSolution {

    private <T> Node<T> createLinkedList(List<T> values) {
        Node<T> head = new Node<>(null);
        Node<T> current = head;
        for (int i = 0; i < values.size(); i++) {
            current.next = new Node<>(values.get(i));
            current = current.next;
        }
        return head.next;
    }

    private <T> Node<T> createLinkedList(List<T> values, int i) {
        if (i == values.size()) {
            return null;
        }
        Node<T> newNode = new Node<>(values.get(i));
        newNode.next = createLinkedList(values, i + 1);
        return newNode;
    }

    @Override
    public void runDefaultExample() {
        printNode(createLinkedList(List.of("h", "e", "y")));
        printNode(createLinkedList(List.of(1, 7, 1, 8)));
        printNode(createLinkedList(List.of("a")));
        printNode(createLinkedList(List.of(List.of())));
    }
}
