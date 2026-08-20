package leetcode_2;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode();
        ListNode cur=dummy;
        boolean isCarry=false;  //是否进位

        while(l1!=null||l2!=null){
            int value1=l1==null?0:l1.val;
            int value2=l2==null?0:l2.val;
            int sum=0;
            if(isCarry){
                sum=value1+value2+1;
            }else{
                sum=value1+value2;
            }
            isCarry=sum>=10;
            cur.next=new ListNode(sum%10);
            cur=cur.next;

            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;
        }
        if(isCarry){
            cur.next=new ListNode(1);
        }
        return dummy.next;
    }
}