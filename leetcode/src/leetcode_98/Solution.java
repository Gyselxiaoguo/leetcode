package leetcode_98;


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
    /***
     * 思路：二叉排序树进行中序遍历后，元素是升序的
     * @param root
     * @return
     */
    List<Integer> list=new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        inorderTraversal(root);//中序遍历
        //遍历，检查是否升序排序
        if(list.size()<=1)return true;
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i)<= list.get(i-1)){
                return false;
            }
        }
        return true;
    }
    private void inorderTraversal(TreeNode node) {
        if(node==null)return;
        inorderTraversal(node.left);
        list.add(node.val);
        inorderTraversal(node.right);
    }
}