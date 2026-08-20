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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list=treePaths(root);
        for(List<Integer> path:list){
            int sum=path.stream().mapToInt(Integer::intValue).sum();
            if(sum==targetSum){
                return true;
            }
        }
        return false;
    }
    private List<List<Integer>> treePaths(TreeNode root){
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        List<Integer> path=new ArrayList<>();
        traversal(root,path,list);
        return list;
    }
    private void traversal(TreeNode root,List<Integer> path,List<List<Integer>> list){
        path.add(root.val);
        if(root.left==null&&root.right==null){
            list.add(new ArrayList<>(path));
            return;
        }

        if(root.left!=null){
            traversal(root.left,path,list);
            path.remove(path.size()-1);
        }

        if(root.right!=null){
            traversal(root.right,path,list);
            path.remove(path.size()-1);
        }
    }
}
