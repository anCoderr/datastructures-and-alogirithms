package DataStructures.ListsAndStacks;

/* ======================================================================
This is our naive implementation of Queue using ListNode class. ListNode is
a single node instance for any type of list(List, Queue, Stack). The following
implementation may or may not work slow as compared to the native implementation
of Queue in JAVA that is done using LinkedList, PriorityQueue, ArrayDeque.
Our methods will allow only FIFO access and updation.
====================================================================== */

public class Queue_ {

    public static class Testing {
        public static void main(String[] args) throws Exception {
            System.out.println("Queue Testing Begins : ");
            Queue_ queue = new Queue_();
            queue.enQueue(0);
            queue.enQueue(1);
            queue.enQueue(2);
            queue.enQueue(3);
            queue.enQueue(4);
            queue.enQueue(5);
            queue.enQueue(6);
            queue.print();
            queue.deQueue();
            queue.deQueue();
            queue.print();
            System.out.println(queue.poll());
            System.out.println(queue.get(3));
            System.out.println(queue.peek());
            queue.print();
            System.out.println(queue.getNode(3).val);
            System.out.println(queue.contains(1));
            System.out.println(queue.getStart().val);
            System.out.println(queue.getHead().val);
        }
    }

    public ListNode temp, prev, head, start;
    public int length, buffer, first;
    public Queue_() {
        head = null;
        start = null;
        length = 0;
    }

    public Exception QueueUnderflowException() throws Exception {
        throw new Exception("Linked List underflow error.\n => The queue is already empty.");
    }
    public Exception QueueOutOfBoundsException() throws Exception {
        throw new Exception("Index out of bounds exception.\n => The queue does not contain the give index");
    }
    public void enQueue(int val) {
        first = val;
        if(length == 0) {
            start = new ListNode(val);
            head = start;
        } else {
            temp = new ListNode(val);
            temp.next = start;
            start = temp;
        }
        length++;
    }
    public void deQueue() throws Exception {
        if(length == 0)
            throw QueueUnderflowException();
        temp = start;
        for(int i = 1; i<length; i++) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        length--;
    }
    public int peek() {
        return first;
    }
    public int poll() throws Exception {
        if(length == 0)
            throw QueueUnderflowException();
        temp = start;
        for(int i = 1; i<length; i++) {
            prev = temp;
            temp = temp.next;
            buffer = temp.val;
        }
        prev.next = null;
        length--;
        return buffer;
    }
    public int get(int index) throws Exception {
        if(index >= length)
            throw QueueOutOfBoundsException();
        temp = start;
        for(int i = 0; i < length && i<=index; i++) {
            buffer = temp.val;
            temp = temp.next;
        }
        return buffer;
    }
    public ListNode getNode(int index) throws Exception {
        if(index >= length)
            throw QueueOutOfBoundsException();
        temp = start;
        for(int i = 0; i < length && i<=index; i++) {
            prev = temp;
            temp = temp.next;
        }
        return prev;
    }
    public void print() {
        temp = start;
        while(temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }
    public ListNode getStart() {
        return start;
    }
    public ListNode getHead() {
        return head;
    }
    public int length() {
        return length;
    }
    public boolean isEmpty() {
        return length==0;
    }
    public boolean contains(int target) {
        temp = start;
        while(temp != null) {
            if(temp.val == target)
                return true;
            temp = temp.next;
        }
        return false;
    }
}

/* ======================================================================
A much more simpler implementation of queue can be done using arrayList.
It is dynamic and our methods will allow only FIFO access and updation.
We do not need to add exceptions as arrayList class takes care of that.
====================================================================== */

//public class Queue_ {
//    ArrayList<Integer> queue;
//    public Queue_() {
//        queue = new ArrayList<>();
//    }
//    public Queue_(int size) {
//        queue = new ArrayList<>(size);
//    }
//    public void enqueue(int val) {
//        queue.add(val);
//    }
//    public void dequeue() {
//        queue.remove(queue.size()-1);
//    }
//    public void poll() {
//        queue.remove(queue.size()-1);
//    }
//    public int peek() {
//        return queue.get(queue.size()-1);
//    }
//    public int get(int index) {
//        return queue.get(index);
//    }
//    public void print() {
//        queue.forEach(i ->System.out.print(i+" -> "));
//        System.out.print("null\n");
//    }
//    public int length() {
//        return queue.size();
//    }
//    public boolean isEmpty() {
//        return queue.size()==0;
//    }
//    public boolean contains(int val) {
//        return queue.contains((Integer) val);
//    }
//}