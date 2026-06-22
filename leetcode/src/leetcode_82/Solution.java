package leetcode_82;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){    //无节点/仅有一个节点
            return head;
        }

        ListNode dummy=new ListNode(-1);
        dummy.next=head;


        ListNode pre=dummy;
        ListNode cur=pre.next;
        while (cur!=null){
            boolean isDuplication=false;
            ListNode next=cur.next;

            while (next!=null&&cur.val==next.val){
                isDuplication=true;
                cur=cur.next;
                next=next.next; //cur、next要同时移动
            }
            if(isDuplication){
                pre.next=cur.next;  //所以才要cur.next
            }else {
                pre=cur;
            }
            cur=cur.next;   //
        }
        return dummy.next;
    }
}