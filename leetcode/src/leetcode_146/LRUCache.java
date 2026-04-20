package leetcode_146;

import java.util.HashMap;
import java.util.Map;

//双向链表
class Node{
    Node pre;
    Node next;
    int key;
    int value;
    Node(int key,int value){
        this.key=key;
        this.value=value;
    }
}


class LRUCache {

    Map<Integer,Node> map=new HashMap<>();
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.pre=head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            cutNode(node);
            insertHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            cutNode(node);
            insertHead(node);
        }else {
            Node node=new Node(key,value);
            map.put(key,node);
            insertHead(node);
            if(map.size()>capacity){//超出存储尺寸
                Node delNode=cutTail();
                map.remove(delNode.key);
            }
        }
    }
    private void cutNode(Node node){//删除节点
        node.pre.next=node.next;
        node.next.pre=node.pre;
        node.pre=null;
        node.next=null;
    }
    private Node cutTail(){//切除最后一个节点
        Node last=tail.pre;
        last.pre.next=tail;
        tail.pre=last.pre;
        last.pre=null;
        last.next=null;
        return last;
    }
    private void insertHead(Node node){//将节点插入到头节点
        Node next=head.next;
        node.next=next;
        node.pre=head;
        next.pre=node;
        head.next=node;
    }
}
