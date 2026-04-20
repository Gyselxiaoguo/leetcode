package leetcode_437;


import java.util.ArrayDeque;
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

/***
 * 广度遍历 + 深度遍历
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)return 0;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        int total=0;//记录个数
        while (!queue.isEmpty()){
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                total+= dfs(node, 0, targetSum);
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
        }
        return total;
    }
    private int dfs(TreeNode node,long curSum,int targetSum){
        if(node==null)return 0;
        int count=0;
        curSum+=node.val;
        if(curSum==targetSum){
            count++;
        }
        count += dfs(node.left, curSum, targetSum);
        count += dfs(node.right,curSum,targetSum);
        return count;
    }

}