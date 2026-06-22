package leetcode_530;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    public int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);
        if(list.size()<2){
            return 0;
        }
        list.sort(( o1,  o2)->o1-o2);
        int minDiff=Integer.MAX_VALUE;
        for (int i = 0; i < list.size()-1; i++) {
            if(Math.abs(list.get(i)-list.get(i+1))<minDiff){
                minDiff=Math.abs(list.get(i)-list.get(i+1));
            }
        }
        return minDiff;
    }

    private void inorderTraversal(TreeNode root) {
        if(root==null){
            return;
        }

        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
    }
}