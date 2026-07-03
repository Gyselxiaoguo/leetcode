package leetcode_23;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        List<ListNode> list=new ArrayList<>();
        //1.将lists中的链表拆分为一个个节点，放到list中
        for (ListNode node : lists) {
            ListNode cur=node;
            while (cur!=null){
                list.add(cur);
                cur=cur.next;
            }
        }
        //2.所有链表都是空，集合无元素
        if(list.isEmpty()){
            return null;
        }
        //3.对节点按照值进行升序排序
        list.sort(( o1,  o2)->o1.val - o2.val);
        //4.连接节点
        for (int i = 0; i < list.size()-1; i++) {
            list.get(i).next=list.get(i+1);
        }
        list.get(list.size()-1).next=null;

        return list.get(0);
    }
}