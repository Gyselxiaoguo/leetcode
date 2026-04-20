package leetcode_101;

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
    /***
     * 判断二叉树是否轴对称
     * 对左右子树进行处理
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }
    private boolean check(TreeNode leftTree,TreeNode rightTree){
        if(leftTree==null && rightTree==null)return true;
        if (leftTree==null || rightTree==null || leftTree.val!=rightTree.val)return false;
        return check(leftTree.left,rightTree.right)&&check(leftTree.right,rightTree.left);
    }
}