package leetcode_92;


import javax.swing.*;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode preLeft=dummy;
        for (int i=1;i<left;i++){   //preLeft在left前
            preLeft= preLeft.next;
        }

        ListNode cur=preLeft.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next=cur.next;
            cur.next=next.next;
            next.next=preLeft.next;
            preLeft.next=next;
        }
        return dummy.next;
    }
}
