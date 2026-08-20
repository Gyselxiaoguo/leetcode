package leetcode_226;



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
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        swapTree(root); //从下往上 依次交换
        return root;
    }
    private void swapTree(TreeNode root){   //交换左右子树
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
    }
}