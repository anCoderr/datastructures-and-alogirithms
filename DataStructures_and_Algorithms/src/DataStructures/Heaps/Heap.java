package DataStructures.Heaps;

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
