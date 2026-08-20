package arithmetic.binaryTreePaths;

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
* 得到从根节点到叶子节点的所有路径
* */
class Solution {
    /**
    * 递归法
    */

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
            list.add(new ArrayList<>(path));    //不能直接添加path，要添加path的副本
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