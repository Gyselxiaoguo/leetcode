package leetcode_2;

import javax.swing.event.ListDataEvent;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head= new ListNode(0);
        ListNode cursor=head;
        int carry=0;
        while (l1!=null||l2!=null||carry!=0){
            int value1=l1!=null?l1.val:0;
            int value2=l2!=null?l2.val:0;
            int sum= value1+value2+carry;
            carry=sum/10;
            ListNode sumNode=new ListNode(sum%10);
            cursor.next=sumNode;
            cursor=sumNode;

            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;

        }
        return head.next;
    }
}