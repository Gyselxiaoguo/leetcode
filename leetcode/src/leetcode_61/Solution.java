package leetcode_61;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        //连成环
        ListNode cur=head;
        int nodeCount=1;
        while (cur.next!=null){
            cur=cur.next;
            nodeCount++;
        }
        cur.next=head;

        for (int i = 0; i < nodeCount - k % nodeCount; i++) {
            cur=cur.next;
        }
        head=cur.next;
        cur.next=null;

        return head;
    }
}