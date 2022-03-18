package DataStructures.ListsAndStacks;

/* ======================================================================
This is our naive implementation of Linked List using ListNode class. ListNode is
a single node instance for any type of list(List, Queue, Stack). The following
implementation may or may not work slow as compared to the native implementation
of Queue in JAVA that is done using LinkedList.
====================================================================== */

public class LinkedList_ {

    public static class Testing {
        public static void main(String[] args) throws Exception {
            System.out.println("Linked List Testing Begins : ");
            LinkedList_ linkedList = new LinkedList_();
            linkedList.add(1);
            linkedList.add(2);
            linkedList.add(3);
            linkedList.add(4);
            linkedList.add(5);
            linkedList.add(6);
            linkedList.print();
            linkedList.add(0, 3);
            linkedList.print();
            linkedList.delete(0);
            linkedList.print();
            System.out.println(linkedList.get(5));
            System.out.println(linkedList.getNode(5).val);
        }
    }

    ListNode head, end;
    private ListNode temp, prev;
    private int length, buffer;

    public LinkedList_() {
        head = null;
        length = 0;
    }

    public Exception ListUnderflowException() throws Exception {
        throw new Exception("Linked List underflow error.\n => The queue is already empty.");
    }

    public Exception IndexOutOfBoundsException() throws Exception {
        throw new Exception("Index out of bounds exception.\n => The queue does not contain the give index");
    }

    public void add(int val) {
        if(length == 0) {
            head = new ListNode(val);
            end = head;
        } else {
            temp = new ListNode(val);
            end.next = temp;
            end = temp;
        }
        length++;
    }

    public void add(int val, int index) throws Exception {
        if(index > length)
            throw IndexOutOfBoundsException();
        if(index == 0) {
            temp = new ListNode(val);
            temp.next = head;
            head = temp;
            end = temp;
        } else {
            temp = head;
            for(int i = 0; i<index; i++) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = new ListNode(val, temp);
            prev.next.next = temp;
        }
        length++;
    }

    public int delete(int index) throws Exception {
        if(length == 0)
            throw ListUnderflowException();
        if(index >= length)
            throw IndexOutOfBoundsException();
        if(index == 0) {
            buffer = head.val;
            length--;
            head = head.next;
            return buffer;
        }
        temp = head;
        for(int i = 0; i<length && i<index; i++) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        length--;
        return temp.val;
    }

    public int get(int index) throws Exception {
        if(index >= length)
            throw IndexOutOfBoundsException();
        temp = head;
        for(int i = 0; i < length && i<index; i++)
            temp = temp.next;
        return temp.val;
    }

    public ListNode getNode(int index) throws Exception {
        if(index >= length)
            throw IndexOutOfBoundsException();
        temp = head;
        for(int i = 0; i < length && i<index; i++)
            temp = temp.next;
        return temp;
    }

    public void print() {
        temp = head;
        while(temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
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
        temp = head;
        while(temp != null) {
            if(temp.val == target)
                return true;
            temp = temp.next;
        }
        return false;
    }
}