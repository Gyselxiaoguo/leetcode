package leetcode_114;


import java.util.ArrayList;
import java.util.List;

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
    public void flatten(TreeNode root) {
        // 处理空树的边界情况
        if (root == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        traverse(root,list);
        TreeNode p=root;
        // 第一步：清空根节点的左节点（核心！）
        p.left = null;
        for (int i = 1; i < list.size(); i++) {
            p.right=new TreeNode(list.get(i));
            // 第二步：清空新节点的左节点（防御性操作）
            p.right.left = null;
            p=p.right;

        }
    }
    //先序遍历
    private void traverse(TreeNode root,List<Integer> list){
        if(root==null)return;
        list.add(root.val);
        if(root.left!=null){
            traverse(root.left,list);
        }
        if(root.right!=null){
            traverse(root.right,list);
        }
    }
}