package leetcode_112;


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


/*
* 先求得所有从根节点到叶子节点的路径
* 再求每条路径上的和
* */
class Solution {
    List<List<Integer>> lists=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        binaryTreePaths(root);
        for(List<Integer> list:lists){
            int sum=list.stream().mapToInt(Integer::intValue).sum();
            if(sum==targetSum){
                return true;
            }
        }
        return false;
    }
    private void binaryTreePaths(TreeNode root){
        path.add(root.val); //先添加
        if(root.left==null&&root.right==null){
            lists.add(new ArrayList<>(path));
            return ;
        }


        if(root.left!=null){
            binaryTreePaths(root.left);
            path.remove(path.size()-1);
        }
        if(root.right!=null){
            binaryTreePaths(root.right);
            path.remove(path.size()-1);
        }
    }
}
