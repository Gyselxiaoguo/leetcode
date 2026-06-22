package leetcode_112;


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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null){    //此时的root为叶子节点
            return targetSum-root.val==0;
        }

        boolean res1 = hasPathSum(root.left, targetSum - root.val);
        boolean res2 = hasPathSum(root.right, targetSum - root.val);

        return res1||res2;
    }
}