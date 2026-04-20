package leetcode_230;


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
    List<Integer> list =new ArrayList<>();

    /***
     * 中序遍历
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root);
        return list.get(k-1);
    }
    private void inorderTraversal(TreeNode node){
        if(node==null)return;
        inorderTraversal(node.left);
        list.add(node.val);
        inorderTraversal(node.right);
    }
}