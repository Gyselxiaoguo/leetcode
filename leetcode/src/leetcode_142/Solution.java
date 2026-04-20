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
    /***
     * 快慢指针处理环形链表问题
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) {
                //相遇时，快指针回到头节点,快指针改为一次移动一步。再次相遇便是入口
                fast=head;
                while(fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}