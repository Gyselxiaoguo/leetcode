package leetcode_129;


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
    List<Integer> list=new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root,0);

        return list.stream().mapToInt(Integer::intValue).sum();
    }


    private void dfs(TreeNode root,int num){
        num=num*10+root.val;
        if(root.left==null&&root.right==null){
            list.add(num);
        }
        if(root.left!=null){
            dfs(root.left, num);
        }
        if(root.right!=null){
            dfs(root.right,num);
        }
    }
}