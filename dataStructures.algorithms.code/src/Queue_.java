import java.util.ArrayList;
import java.util.Queue;

public class Queue_ {
    ArrayList<Integer> queue;
    public Queue_() {
        queue = new ArrayList<>();
    }
    public Queue_(int size) {
        queue = new ArrayList<>(size);
    }
    public void enqueue(int val) {
        queue.add(val);
    }
    public void dequeue() {
        queue.remove(queue.size()-1);
    }
    public int poll() {
        return queue.remove(queue.size()-1);
    }
    public int get(int index) {
        return queue.get(index);
    }
    public void print() {
        for(int i : queue)
            System.out.print(i + " ");
        System.out.println();
    }
    public int length() {
        return queue.size();
    }
    public boolean isEmpty() {
        return queue.size()==0;
    }
    public boolean contains(int val) {
        for(int i : queue)
            if(i == val)
                return true;
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    public ListNode(int val) {
        this.val = val;
        next = null;
        prev = null;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
        prev = null;
    }
    public ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
