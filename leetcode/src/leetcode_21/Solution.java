package leetcode_21;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head=new ListNode();
        ListNode cur=head;
        while (list1 != null && list2 != null) {
            if(list1.val<=list2.val){
                cur.next = new ListNode(list1.val);
                list1=list1.next;
            }else {
                cur.next = new ListNode(list2.val);
                list2=list2.next;
            }
            cur=cur.next;
        }
        if(list1==null){
            cur.next=list2;
        }
        if(list2==null){
            cur.next=list1;
        }
        return head.next;
    }
}