package leetcode_234;



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/***
 * 思路：原链表遍历后=反转链表
 * 快慢指针判断中位数
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            //只有一个元素或没有元素
            return true;
        }
        if(head.next.next==null){
            //只有两个元素
            return head.val==head.next.val;
        }

        //通过快慢指针确定中位数
        ListNode fast=head;
        ListNode slow=head;
        while (fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode mid=slow;

        //判断左边是否=右边的逆序
        ListNode left=head;
        ListNode right=reverse(mid.next);
        return isEqual(left, right);
    }
    //反转链表
    private ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        ListNode next;
        while (cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
    //判断左右链表是否相同
    private boolean isEqual(ListNode left,ListNode right){
        while (right!=null){
            if(left.val!=right.val){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }

}