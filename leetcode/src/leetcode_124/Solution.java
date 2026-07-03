package leetcode_124;


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
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    private int maxGain(TreeNode node){
        if(node==null){ //递归出口
            return 0;
        }

        int lGain=Math.max(maxGain(node.left),0);   //节点为负数就舍弃
        int rGain=Math.max(maxGain(node.right),0);
        int curMax=node.val+lGain+rGain;    //以当前节点为根节点所组成的最长路径
        maxSum=Math.max(curMax,maxSum);
        return node.val+Math.max(lGain,rGain);  //避免在同一个节点分叉
    }
}