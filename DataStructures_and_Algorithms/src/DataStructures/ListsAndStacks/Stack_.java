package DataStructures.ListsAndStacks;

import Exceptions.ExceptionsGenerator;

import java.util.ArrayList;
import java.util.Stack;

/* ======================================================================
A much more simpler implementation of stack done using arrayList.
It is dynamic and our methods will allow only LIFO access and updation.
We do not need to add exceptions as arrayList class takes care of that.
====================================================================== */

public class Stack_ {
    static String UNDERFLOW_ERROR_MSG = "Stack underflow error.\n";
    // Runner class
    static class Runner{
        public static void main (String[] args) throws Exception {
            Stack_ stack = new Stack_();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(0);
            stack.push(4);
            stack.push(5);
            stack.push(6);
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.size);
            System.out.println(stack.peek());
        }
    }
    ListNode head, temp;
    int size, buffer;

    public  Stack_() {
        head = null;
        size = 0;
    }

    public void push(int val) {
        size++;
        temp = new ListNode(val, head);
        head = temp;
    }

    public int pop() throws Exception{
        if(size == 0)
            throw new ExceptionsGenerator(UNDERFLOW_ERROR_MSG + "Error Message: The stack is already empty. Cannot pop() from empty Stack");
        buffer = head.val;
        head = head.next;
        size--;
        return buffer;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int peek() throws Exception {
        if(size == 0)
            throw new ExceptionsGenerator(UNDERFLOW_ERROR_MSG + "Error Message: The stack is already empty. Cannot peek() at a Stack");
        return head.val;
    }
}

///* ======================================================================
//A much more simpler implementation of stack done using arrayList.
//It is dynamic and our methods will allow only LIFO access and updation.
//We do not need to add exceptions as arrayList class takes care of that.
//====================================================================== */
//
//public class Stack_ {
//    ArrayList<Integer> stack;
//    int size;
//    public  Stack_() {
//        stack = new ArrayList<>();
//        size = 0;
//    }
//    public void push(int val) {
//        size++;
//        stack.add(val, 0);
//    }
//    public int pop() {
//        size--;
//        return stack.remove(0);
//    }
//    public int size() {
//        return size;
//    }
//    public boolean isEmpty() {
//        return size==0;
//    }
//    public int peek() {
//        return stack.get(0);
//    }
//}
