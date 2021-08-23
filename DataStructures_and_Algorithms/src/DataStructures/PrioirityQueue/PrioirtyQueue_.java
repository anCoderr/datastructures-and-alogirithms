package DataStructures.PrioirityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;


public class PrioirtyQueue_ {
    // Tester class
    public static class Tester {
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
}
