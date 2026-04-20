package leetcode_104;

import java.util.Map;

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

public class Solution {
    /***
     * 求二叉树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        int leftMaxDepth=maxDepth(root.left);
        int rightMaxDepth=maxDepth(root.right);
        return Math.max(leftMaxDepth,rightMaxDepth)+1;
    }
}