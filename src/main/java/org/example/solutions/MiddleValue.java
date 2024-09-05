package org.example.solutions;

import java.util.ArrayList;
import java.util.List;

public class MiddleValue implements DefaultSolution {

    private <T> T middleValue(Node<T> head) {
        Node<T> current = head;
        List<T> values = new ArrayList<>();
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
        int middle = (values.size()) / 2;
        return values.get(middle);
    }


    @Override
    public void runDefaultExample() {

    }
}
