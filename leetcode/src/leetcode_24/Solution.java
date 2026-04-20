package leetcode_24;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy =new ListNode(0,head);
        ListNode pre=dummy;
        ListNode first=pre.next;
        ListNode second=null;
        while (first!=null && first.next!=null){
            second=first.next;
            ListNode nxt=second.next;

            pre.next=second;
            second.next=first;
            first.next=nxt;
            pre=first;
            first=nxt;
        }
        return dummy.next;
    }
}