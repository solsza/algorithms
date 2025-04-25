package org.example.solutions.heap;

import java.util.ArrayList;
import java.util.List;

public class HeapInsertion {

    static class MinHeap {

        public List<Double> list;

        public MinHeap() {
            list = new ArrayList<>();

        }

        public int size() {
            return list.size();
        }

        public boolean isEmpty() {
            return list.size() == 0;
        }

        public void swap(int idx1, int idx2) {
            Double temp = this.list.get(idx1);
            this.list.set(idx1, this.list.get(idx2));
            this.list.set(idx2, temp);
        }

        public void siftUp(int idx) {
            int currentIdx = idx;
            while (currentIdx > 0) {
                int parentIdx = (int) Math.floor((currentIdx - 1) / 2.0);
                if (list.get(currentIdx) < list.get(parentIdx)) {
                    swap(currentIdx, parentIdx);
                    currentIdx = parentIdx;
                } else {
                    break;
                }
            }
        }

        public void insert(Double val) {
            list.add(val);
            siftUp(list.size() - 1);
        }
    }

}
