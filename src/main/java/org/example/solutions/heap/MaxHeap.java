package org.example.solutions.heap;

import org.example.solutions.DefaultSolution;

public class MaxHeap implements DefaultSolution {

    private int[] heap;
    private int size;
    private int maxsize;

    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        heap = new int[this.maxsize];
    }

    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    private boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    private void maxHeapify(int pos) {
        if (isLeaf(pos)) {
            return;
        }

        if (heap[pos] < heap[leftChild(pos)]
            || heap[pos] < heap[rightChild(pos)]) {

            if (heap[leftChild(pos)]
                > heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    public void insert(int element) {
        heap[size] = element;

        // Traverse up and fix violated property
        int current = size;
        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    public void print() {

        for (int i = 0; i < size / 2; i++) {

            System.out.print("Parent Node : " + heap[i]);

            if (leftChild(i)
                < size) // if the child is out of the bound
            // of the array
            {
                System.out.print(" Left Child Node: "
                    + heap[leftChild(i)]);
            }

            if (rightChild(i)
                < size) // the right child index must not
            // be out of the index of the array
            {
                System.out.print(" Right Child Node: "
                    + heap[rightChild(i)]);
            }

            System.out.println(); // for new line
        }
    }

    public int extractMax() {
        int popped = heap[0];
        heap[0] = heap[--size];
        maxHeapify(0);
        return popped;
    }

    @Override
    public void runDefaultExample() {
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.print();
        System.out.println("The max val is "
            + maxHeap.extractMax());
    }

}
