package leetcode_106;


import java.util.HashMap;
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
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0||postorder.length==0){
            return null;
        }

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        return buildSubTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }

    private TreeNode buildSubTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart>inEnd||postStart>postEnd){
            return null;
        }

        //1.根节点
        TreeNode root = new TreeNode(postorder[postEnd]);
        //2.根节点在中序遍历的位置
        int rootIndex = map.get(postorder[postEnd]);
        //3.左子树节点个数
        int lSize = rootIndex - inStart;
        //4.构建左子树
        root.left=buildSubTree(inorder,postorder,inStart,inStart+lSize-1,postStart,postStart+ lSize-1);
        //5.构建右子树
        root.right=buildSubTree(inorder,postorder,inStart+lSize+1,inEnd,postStart+lSize,postEnd-1);

        return root;

    }
}