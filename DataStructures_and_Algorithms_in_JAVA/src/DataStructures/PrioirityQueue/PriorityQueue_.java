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
        public static void main(String[] args) throws Exception {
            /* The default priority queue implementation in JAVA
               It uses MinHeap by default if comparator is not specified */
            System.out.println("Default Minimum Priority Queue Implementation in JAVA");
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
            System.out.println("Default Maximum Priority Queue Implementation in JAVA");
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

            System.out.println("Our Implementation of Min Priority Queue in JAVA");
            PriorityQueue_ pqMin = new PriorityQueue_(true);

            pqMin.enQueue(3);
            pqMin.enQueue(0);
            pqMin.enQueue(1);
            pqMin.enQueue(4);
            pqMin.enQueue(5);
            pqMin.enQueue(2);
            System.out.println(pqMin.deQueue());
            System.out.println(pqMin.deQueue());
            System.out.println(pqMin.peek());

            System.out.println("Our Implementation of Max Priority Queue in JAVA");
            PriorityQueue_ pqMax = new PriorityQueue_(false);
            pqMax.enQueue(0);
            pqMax.enQueue(1);
            pqMax.enQueue(2);
            pqMax.enQueue(3);
            pqMax.enQueue(4);
            pqMax.enQueue(5);
            System.out.println(pqMax.deQueue());
            System.out.println(pqMax.deQueue());
            System.out.println(pqMax.peek());
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

    public int deQueue() throws Exception {
        if(size == 0)
            throw new ExceptionsGenerator(UNDERFLOW_ERROR_MSG + "Error Message: The priority queue is empty. Cannot poll() from an empty priority queue");
        size--;
        return pq.poll();
    }

    public int peek() throws Exception {
        if(size == 0)
            throw new ExceptionsGenerator(UNDERFLOW_ERROR_MSG + "Error Message: The priority queue is empty. Cannot peek() at an empty priority queue");
        return pq.peek();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
