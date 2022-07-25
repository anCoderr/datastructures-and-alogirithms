package SolutionsInJAVA;

import LeetcodeDefaultImplementationsOfDS.ListNode;

public class Leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = null;
        ListNode ansHead = null;
        int carry = 0;
        int i = 0;
        while(l1 != null || l2 != null) {
            if(ans == null) {
                ans = new ListNode();
                ansHead = ans;
            } else {
                ans.next = new ListNode();
                ans = ans.next;
            }
            i = 0;
            i += (l1 != null)? l1.val : 0;
            i += (l2 != null)? l2.val : 0;
            i += carry;
            carry = (i >= 10)? 1 : 0;
            i = i%10;
            ans.val = i;
            l1 = (l1 != null)? l1.next : null;
            l2 = (l2 != null)? l2.next : null;
        }
        if(carry == 1){
            ans.next = new ListNode();
            ans = ans.next;
            ans.val = carry;
            ans.next = null;
        }
        return ansHead;
    }
}
