package leetcode_24;


import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode preGroup=dummy;
        int groupSize=2;

        while (true){
            ListNode check=preGroup;
            for (int i = 0; i < groupSize; i++) {
                check=check.next;
                if(check==null){
                    return dummy.next;
                }
            }

            ListNode pre=preGroup;
            ListNode cur=pre.next;
            for (int i = 1; i < groupSize; i++) {
                ListNode next=cur.next;
                cur.next=next.next;
                next.next=pre.next;
                pre.next=next;
            }
            preGroup=cur;
        }
    }
}
