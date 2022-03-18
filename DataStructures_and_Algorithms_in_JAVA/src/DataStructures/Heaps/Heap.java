package DataStructures.Heaps;

import java.util.ArrayList;

public interface  Heap {
    boolean hasLeftChildIndex(int index);
    boolean hasRightChildIndex(int index);
    boolean hasParentIndex(int index);
    int getLeftChildIndex(int parentIndex);
    int getRightChildIndex(int parentIndex);
    int getParentIndex(int childIndex);
    int getLeftChild(int parentIndex);
    int getRightChild(int parentIndex);
    int getParent(int childIndex);
    void swapElements(int i1, int i2);
    int peek();
    int poll();
    void add(int val);
    void heapifyUp();
    void heapifyDown();
}

//abstract class Heap {
//    int size;
//    ArrayList<Integer> heap;
//
//    boolean hasLeftChildIndex(int index) {
//        return false;
//    }
//
//    boolean hasRightChildIndex(int index) {
//        return false;
//    }
//
//    boolean hasParentIndex(int index) {
//        return false;
//    }
//
//    int getLeftChildIndex(int parentIndex) {
//        return 0;
//    }
//
//    int getRightChildIndex(int parentIndex) {
//        return 0;
//    }
//
//    int getParentIndex(int childIndex) {
//        return 0;
//    }
//
//    int getLeftChild(int parentIndex) {
//        return 0;
//    }
//
//    int getRightChild(int parentIndex) {
//        return 0;
//    }
//
//    int getParent(int childIndex) {
//        return 0;
//    }
//
//    void swapElements(int i1, int i2) {}
//
//    int peek() {
//        return 0;
//    }
//
//    int poll() {
//        return 0;
//    }
//
//    void add(int val) {}
//
//    void heapifyUp() {}
//
//    void heapifyDown() {}
//}