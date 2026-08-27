package leetcode_114;


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
    public void flatten(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        traverse(root,list);
        int size=list.size();
        if(size<=1){
            return;
        }

        for(int i=1;i<size;i++){
            root.left=null;
            root.right=new TreeNode(list.get(i));
            root=root.right;
        }
    }
    //先序遍历
    private void traverse(TreeNode root,List<Integer> list){
        if(root==null)return;
        list.add(root.val);
        if(root.left!=null){
            traverse(root.left,list);
        }
        if(root.right!=null){
            traverse(root.right,list);
        }
    }
}