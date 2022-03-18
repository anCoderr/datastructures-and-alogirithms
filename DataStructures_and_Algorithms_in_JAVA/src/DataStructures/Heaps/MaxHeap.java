package DataStructures.Heaps;

import java.util.ArrayList;

public class MaxHeap implements Heap{

    static class Runner {
        public static void main(String[] args) {
            MaxHeap maxHeap = new MaxHeap();
            maxHeap.add(1);
            maxHeap.add(4);
            maxHeap.add(5);
            maxHeap.add(0);
            maxHeap.add(8);
            maxHeap.add(2);
            System.out.println(maxHeap.poll());
            System.out.println(maxHeap.poll());
            System.out.println(maxHeap.poll());
            System.out.println(maxHeap.peek());
        }
    }

    int size;
    ArrayList<Integer> heap;

    public MaxHeap() {
        size = 0;
        heap = new ArrayList<>();
    }

    public boolean hasLeftChildIndex(int index) {
        return getLeftChildIndex(index) < size;
    }
    public boolean hasRightChildIndex(int index) {
        return getRightChildIndex(index) < size;
    }
    public boolean hasParentIndex(int index) {
        return getParentIndex(index) >= 0;
    }
    public int getLeftChildIndex(int parentIndex) {
        return 2*parentIndex+1;
    }
    public int getRightChildIndex(int parentIndex) {
        return 2*parentIndex+2;
    }
    public int getParentIndex(int childIndex) {
        return (childIndex-1)/2;
    }
    public int getLeftChild(int parentIndex) {
        return heap.get(getLeftChildIndex(parentIndex));
    }
    public int getRightChild(int parentIndex) {
        return heap.get(getRightChildIndex(parentIndex));
    }
    public int getParent(int childIndex) {
        return heap.get(getParentIndex(childIndex));
    }

    public void swapElements(int i1, int i2) {
        int temp = heap.get(i1);
        heap.set(i1, heap.get(i2));
        heap.set(i2, temp);
    }

    public int peek() {
        return heap.get(0);
    }

    public int poll() {
        int temp = heap.get(0);
        heap.set(0, heap.get(size-1));
        heap.remove(size-1);
        size--;
        heapifyDown();
        return temp;
    }

    public void add(int val) {
        heap.add(val);
        size++;
        heapifyUp();
    }

    public void heapifyUp() {
        int index = size-1;
        while(hasParentIndex(index) && getParent(index) < heap.get(index)) {
            swapElements(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void heapifyDown() {
        int index = 0, larger;
        while(hasLeftChildIndex(index)) {
            larger = getLeftChildIndex(index);
            if(hasRightChildIndex(index) && getLeftChild(index) < getRightChild(index))
                larger =  getRightChildIndex(index);
            if(heap.get(index) > heap.get(larger))
                break;
            swapElements(index, larger);
            index = larger;
        }
    }
}