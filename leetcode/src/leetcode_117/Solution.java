package leetcode_117;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    /**
     * 层序遍历出每层节点，之后将每层节点进行连接
     * @param root
     * @return
     */
    public Node connect(Node root) {
        List<List<Node>> list= levelOrder(root);
        // 遍历每一层
        for (List<Node> layer : list) {
            // 一层里逐个连next
            for (int i = 0; i < layer.size()-1; i++) {
                Node cur=layer.get(i);
                Node nextNode = layer.get(i + 1);
                cur.next=nextNode;
            }
        }
        return root;
    }

    private List<List<Node>> levelOrder(Node root) {
        List<List<Node>> list=new ArrayList<>();
        Queue<Node> queue=new ArrayDeque<>();

        if(root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Node> level=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            list.add(level);
        }
        return list;
    }
}
