package leetcode_19;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0,head);//虚拟节点，方便找头节点
        ListNode left=dummy;
        ListNode right=head;
        int i=0;
        while (i<n){
            right=right.next;
            i++;
        }
        while (right!=null){
            left=left.next;
            right=right.next;
        }
        left.next=left.next.next;
        return dummy.next;
    }
}