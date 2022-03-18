package DataStructures.ListsAndStacks;

public class ListNode {
    public int val;
    ListNode next;
    public ListNode() {
        next = null;
    }
    public ListNode(int val) {
        this.val = val;
        next = null;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
