package leetcode_105;


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
    private Map<Integer,Integer> inorderIndexMap=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0){
            return null;
        }

        //记录中序遍历的索引值
        /*
        * 2 1 5 7 3
        * 0 1 2 3 4
        * */
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i],i);
        }
        return buildSubTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    private TreeNode buildSubTree(int[] preorder,int[] inorder,int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // 1. 前序遍历的第一个元素是当前子树的根节点
        TreeNode root = new TreeNode(preorder[preStart]);
        // 2. 找到根节点在中序遍历中的索引
        Integer rootIndex = inorderIndexMap.get(root.val);
        //3.左子树节点个数
        int leftSize = rootIndex - inStart;
        // 4. 递归构建左子树
        root.left=buildSubTree(preorder,inorder,preStart+1,preStart+leftSize,inStart,inStart+leftSize-1);
        //5.递归构建右子树
        root.right=buildSubTree(preorder,inorder,preStart+leftSize+1,preEnd,inStart+leftSize+1,inEnd);

        return root;
    }
}


