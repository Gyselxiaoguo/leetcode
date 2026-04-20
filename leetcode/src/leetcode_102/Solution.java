package leetcode_102;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    //采用广度优先遍历求解
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new ArrayDeque<>();//使用队列存放节点
        if(root!=null)queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> level=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
            res.add(level);
        }
        return res;
    }
}