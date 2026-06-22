package leetcode_133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public int val;
    public List<Node> neighbors;    //邻居的列表
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    // 全局map：节点值 -> 克隆后的新节点
    Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }

        return dfs(node);
    }

    private Node dfs(Node node) {
        // 如果该值对应的克隆节点已存在，直接返回，不用重复创建
        if (map.get(node.val) != null) {
            return map.get(node.val);
        }

        // 1. 创建当前节点的克隆节点
        Node ret = new Node(node.val);
        List<Node> list = new ArrayList<>();
        ret.neighbors = list;
        // 先存入map！防止递归邻居时回头重复创建
        map.put(node.val, ret);

        for (Node item : node.neighbors) {
            Node node1 = map.get(item.val);
            // 邻居没克隆过，递归dfs生成
            if(node1==null){
                node1 = dfs(item);
            }
            // 把克隆后的邻居加入当前克隆节点邻接表
            list.add(node1);
        }
        return ret;
    }
}
