package leetcode_543;

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
    int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }
    private int depth(TreeNode root){
        if(root==null)return 0;
        int left = depth(root.left);    // 左子树最大深度
        int right = depth(root.right);  // 右子树最大深度
        ans=Math.max(ans,left+right);   // 左边最深一条链 + 右边最深一条链，就是穿过本节点的路径边数
        return Math.max(left,right)+1;  // 向上返回给父节点：当前子树的最大深度
    }
}