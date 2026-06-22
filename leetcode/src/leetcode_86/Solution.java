package leetcode_86;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    /*
    * 创建两个新链表，分别用来记录 小于x的节点&大于等于x的节点
    * */
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1=new ListNode(-1);
        ListNode dummy2=new ListNode(-1);
        ListNode cur1=dummy1;
        ListNode cur2=dummy2;
        while (head!=null){
            if(head.val<x){
                cur1.next= new ListNode(head.val);
                cur1=cur1.next;
            }else {
                cur2.next=new ListNode(head.val);
                cur2=cur2.next;
            }
            head=head.next;
        }
        cur1.next=dummy2.next;
        return dummy1.next;
    }
}