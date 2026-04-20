package leetcode_199;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
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

class Solution {
    /***
     * 右视图
     * 思路：层序遍历，取每层的最后一个
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> lists = levelOrder(root);
        for (List<Integer> list : lists) {
            ans.add(list.get(list.size()-1));
        }
        return ans;
    }
    //广度优先法进行层序遍历
    private List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new ArrayDeque<>();
        if(root!=null)queue.add(root);
        while (!queue.isEmpty()){
            int n=queue.size();
            List<Integer> level=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
            res.add(level);
        }
        return res;
    }
}