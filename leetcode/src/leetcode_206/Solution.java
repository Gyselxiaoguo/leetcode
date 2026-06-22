package leetcode_206;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    /*用头插法实现完整链表反转*/
    public ListNode reverseList(ListNode head) {
        //节点个数<=1
        if(head==null||head.next==null){
            return head;
        }

        //节点个数>=2
        ListNode dummy=new ListNode(-1);
        dummy.next=head;

        ListNode pre=dummy;
        ListNode cur=pre.next;
        while (cur.next!=null){
            ListNode next=cur.next;
            cur.next=next.next;
            next.next=pre.next;
            pre.next=next;
        }
        return pre.next;
    }
}