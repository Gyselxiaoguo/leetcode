package leetcode_25;


import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


//k个一组反转链表，不够分为一组的保持不变
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }

        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode preGroup=dummy;

        while (true) {
            ListNode check=preGroup;
            for (int i = 0; i < k; i++) {
                check=check.next;
                if(check==null){
                    return dummy.next;
                }
            }

            ListNode pre=preGroup;
            ListNode cur=pre.next;
            for (int i = 1; i < k; i++) {
                ListNode next=cur.next;
                cur.next=next.next;
                next.next=pre.next;
                pre.next=next;
            }
            preGroup=cur;
        }
    }
}


//k个一组反转链表，不够分为一组的仍然翻转  (字节跳动面试题）
/*
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }

        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode preGroup=dummy;

        while (true) {
            if(preGroup.next==null){
                break;
            }
            ListNode pre=preGroup;
            ListNode cur=pre.next;
            for (int i = 1; i < k; i++) {
                ListNode next=cur.next;
                // next为空时，停止本轮翻转（剩下不足k个也翻到尽头）
                if (next == null) break;

                cur.next=next.next;
                next.next=pre.next;
                pre.next=next;
            }
            preGroup=cur;
        }
        return dummy.next;
    }
}*/
