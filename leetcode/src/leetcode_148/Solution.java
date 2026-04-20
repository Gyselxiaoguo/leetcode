package leetcode_148;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)return head;

        ListNode mid=findMiddle(head);
        ListNode rightHead=mid.next;
        mid.next=null;

        ListNode left=sortList(head);
        ListNode right=sortList(rightHead);

        return mergeTwoSortedLists(left, right);
    }

    private ListNode mergeTwoSortedLists(ListNode left, ListNode right) {
        ListNode dummy=new ListNode(-1);
        ListNode curr = dummy;
        while (left!=null && right!=null){
            if(left.val>right.val){
                curr.next=right;
                right=right.next;
            }else {
                curr.next=left;
                left=left.next;
            }
            curr=curr.next;
        }
        curr.next=left==null?right:left;
        return dummy.next;
    }

    private ListNode findMiddle(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode fast=head.next;
        ListNode slow=head;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

}