package leetcode_538;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    Map<Integer,Integer> map=new HashMap<>();   //当前节点的值，比它大的所有节点之和
    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        if(list.isEmpty()){
            return root;
        }
        int sum=list.stream().mapToInt(Integer::intValue).sum();
        map.put(list.get(0),sum-list.get(0));
        for(int i=1;i<list.size();i++){
            map.put(list.get(i),map.get(list.get(i-1))-list.get(i));
        }
        traversal(root);
        return root;
    }
    //中序遍历
    private void inorder(TreeNode root){
        if(root==null){
            return ;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    //每个节点加上比它大的所有节点和
    private void traversal(TreeNode root){
        if(root==null){
            return;
        }
        root.val+=map.get(root.val);
        traversal(root.left);
        traversal(root.right);
    }
}