package leetcode_142;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        boolean isNotMeet=true;
        while(fast.next!=null&&fast.next.next!=null){
            if(isNotMeet){
                slow=slow.next;
                fast=fast.next.next;
                if(slow==fast){
                    isNotMeet=false;
                    fast=head;
                }
            }else{  //相遇时，快指针回到头节点,快指针改为一次移动一步。再次相遇便是入口
                if(slow==fast){
                    return slow;
                }
                slow=slow.next;
                fast=fast.next;
            }
        }
        return null;
    }
}