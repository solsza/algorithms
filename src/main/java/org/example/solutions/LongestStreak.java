package org.example.solutions;

public class LongestStreak implements DefaultSolution {

    private <T> int longestStreak(Node<T> head) {
        Node<T> current = head;
        int maxStreak = 0;
        int currentStreak = 0;
        T prevVal = null;
        while (current != null) {
            if (prevVal == current.val) {
                currentStreak += 1;
            } else {
                currentStreak = 1;
            }
            if (currentStreak > maxStreak) {
                maxStreak = currentStreak;
            }
            prevVal = current.val;
            current = current.next;
        }
        return maxStreak;
    }

    @Override
    public void runDefaultExample() {
        Node<Integer> a = new Node<>(5);
        Node<Integer> b = new Node<>(5);
        Node<Integer> c = new Node<>(7);
        Node<Integer> d = new Node<>(7);
        Node<Integer> e = new Node<>(7);
        Node<Integer> f = new Node<>(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        // 5 -> 5 -> 7 -> 7 -> 7 -> 6

        System.out.println(longestStreak(a)); // 3
    }
}
