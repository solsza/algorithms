package org.example.solutions;

import java.util.LinkedList;
import java.util.List;

public class TraversThroughLinkedList implements DefaultSolution {

    private void traversThoughLinkedList(Node[] nodes) {
        System.out.println("Traverse thought linked list ");
        Node head = nodes[0];
        System.out.println("head value: " + head.val);
        while (head.next != null) {
            System.out.println("next value: " + head.next.val);
            head = head.next;
        }
    }

    private void traversThoughLinkedList2(Node<Integer>[] nodes) {
        System.out.println("Traverse thought linked list ");
        recursiveTraversLinkedList(nodes[0]);
    }

    private void recursiveTraversLinkedList(Node<Integer> head) {
        if (head == null) {
            return;
        }
        System.out.println("Value " + head.val);
        recursiveTraversLinkedList(head.next);
        System.out.println("Value " + head.val);
    }

    private List<String> traversThoughLinkedListAndReturnElementsAsList(Node<String> head) {
        LinkedList<String> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    private List<String> traversThoughLinkedListAndReturnElementsAsList2(Node<String> head, LinkedList<String> result) {
        if (head == null) {
            return result;
        }
        result.add(head.val);
        return traversThoughLinkedListAndReturnElementsAsList2(head.next, result);
    }


    @Override
    public void runDefaultExample() {
        Node<Integer> node = new Node<>(1);
        Node<Integer> node2 = new Node<>(5);
        node.next = node2;
        Node<Integer> node3 = new Node<>(2);
        node2.next = node3;
        Node<Integer> node4 = new Node<>(7);
        node3.next = node4;
        Node<Integer>[] nodes = new Node[]{node, node2, node3, node4};
        traversThoughLinkedList(nodes);
        traversThoughLinkedList2(nodes);
        Node<String> nodeS = new Node<>("a");
        Node<String> nodeS2 = new Node<>("b");
        nodeS.next = nodeS2;
        Node<String> nodeS3 = new Node<>("c");
        nodeS2.next = nodeS3;
        Node<String> nodeS4 = new Node<>("d");
        nodeS3.next = nodeS4;
        System.out.println(traversThoughLinkedListAndReturnElementsAsList(nodeS));
        System.out.println(traversThoughLinkedListAndReturnElementsAsList2(nodeS, new LinkedList<>()));
    }
}
