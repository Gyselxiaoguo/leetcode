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
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        binaryTreePaths(root,lists,path);
        int res=0;
        for(List<Integer> list:lists){
            int num=0;
            for(int i=0;i<list.size();i++){
                num=num*10+list.get(i);
            }
            res+=num;
        }
        return res;
    }
    private void binaryTreePaths(TreeNode root,List<List<Integer>> lists,List<Integer> path){
        path.add(root.val);
        if(root.left==null&&root.right==null){
            lists.add(new ArrayList<>(path));
            return;
        }
        if(root.left!=null){
            binaryTreePaths(root.left,lists,path);
            path.remove(path.size()-1);
        }
        if(root.right!=null){
            binaryTreePaths(root.right,lists,path);
            path.remove(path.size()-1);
        }
    }
}