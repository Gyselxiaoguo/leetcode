package leetcode_138;

import java.util.HashMap;
import java.util.Map;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        Map<Node,Node> map=new HashMap<>();
        Node cur=head;
//        复制所有节点，只填充 val
        while (cur!=null){
            Node newNode=new Node(cur.val);
            map.put(cur,newNode);
            cur=cur.next;
        }
//        填充 next 和 random 指针
        cur=head;
        while (cur!=null){
            Node newNode=map.get(cur);
            newNode.next=map.get(cur.next);
            newNode.random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }
}