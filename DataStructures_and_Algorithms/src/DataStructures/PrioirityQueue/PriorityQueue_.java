package DataStructures.PrioirityQueue;

import DataStructures.Heaps.Heap;
import DataStructures.Heaps.MaxHeap;
import DataStructures.Heaps.MinHeap;
import Exceptions.ExceptionsGenerator;
import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueue_ {
    static String UNDERFLOW_ERROR_MSG = "Priority Queue underflow error.\n";
    // Runner class for testing
    public static class Runner {
        public static void main(String[] args) {
            /* The default priority queue implementation in JAVA
               It uses MinHeap by default if comparator is not specified */
            PriorityQueue<Integer> pqMinHeap = new PriorityQueue<>();
            pqMinHeap.add(89);
            pqMinHeap.add(12);
            pqMinHeap.add(1);
            pqMinHeap.add(99);
            pqMinHeap.add(18);
            pqMinHeap.add(0);
            pqMinHeap.add(112);
            pqMinHeap.add(19);
            System.out.println(pqMinHeap.poll());
            System.out.println(pqMinHeap.poll());
            System.out.println(pqMinHeap.poll());
            /* Collections.reverseOrder() is a descending order comparator
               provided by the Collections class. So our priority queue
               not uses MaxHeap for ordering */
            PriorityQueue<Integer> pqMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
            pqMaxHeap.add(87);
            pqMaxHeap.add(11);
            pqMaxHeap.add(2);
            pqMaxHeap.add(97);
            pqMaxHeap.add(19);
            pqMaxHeap.add(0);
            pqMaxHeap.add(112);
            pqMaxHeap.add(19);
            System.out.println(pqMaxHeap.poll());
            System.out.println(pqMaxHeap.poll());
            System.out.println(pqMaxHeap.poll());
            System.out.println(pqMaxHeap.poll());
            System.out.println(pqMaxHeap.poll());
            System.out.println(pqMaxHeap.poll());
        }
    }

    Heap pq;
    int size, buffer;

    public PriorityQueue_(boolean useMinHeap) {
        if(useMinHeap)
            pq = new MinHeap();
        else
            pq = new MaxHeap();
        size = 0;
    }

    public void enQueue(int val) {
        pq.add(val);
        size++;
    }

    public int deQueue(int val) throws Exception {
        if(size == 0)
            throw new ExceptionsGenerator(UNDERFLOW_ERROR_MSG + "Error Message: The priority queue is empty. Cannot poll() from an empty priority queue");
        size--;
        return pq.poll();
    }

    public void peek(int val) throws Exception {
        if(size == 0)
            throw new ExceptionsGenerator(UNDERFLOW_ERROR_MSG + "Error Message: The priority queue is empty. Cannot peek() at an empty priority queue");
        pq.peek();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
