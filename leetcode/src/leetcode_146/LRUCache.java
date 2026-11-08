package leetcode_146;

import java.util.HashMap;
import java.util.Map;

//双向链表
class ListNode {
    ListNode pre;
    ListNode next;
    int key;
    int value;
    ListNode(){}
    ListNode(int key, int value){
        this.key=key;
        this.value=value;
    }
}


class LRUCache {

    Map<Integer, ListNode> map=new HashMap<>();  //Map集合
    int capacity;
    ListNode head=new ListNode();                             //双链表标配，头尾节点
    ListNode tail=new ListNode();

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.pre=head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            ListNode node=map.get(key);
            cutNode(node);
            insertHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode node=map.get(key);
            node.value=value;
            cutNode(node);
            insertHead(node);
        }else {
            ListNode node=new ListNode(key,value);
            map.put(key,node);
            insertHead(node);
            if(map.size()>capacity){//超出存储尺寸
                ListNode delNode=cutTail();
                map.remove(delNode.key);
            }
        }
    }

    //1.删除当前节点
    private void cutNode(ListNode node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
        node.pre=null;
        node.next=null;
    }

    //2.切除最后一个节点
    private ListNode cutTail(){
        ListNode last=tail.pre;
        cutNode(last);
        return last;
    }

    //3.将节点插入到头节点
    private void insertHead(ListNode node){
        ListNode oldFirst=head.next;
        node.next=oldFirst;
        node.pre=head;
        oldFirst.pre=node;
        head.next=node;
    }
}
