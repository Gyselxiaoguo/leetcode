package leetcode_173;


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

class BSTIterator {
    List<Integer> list =new ArrayList<>();
    int index=-1;
    int length=0;

    public BSTIterator(TreeNode root) {
        inorderTraversal(root);
        length=list.size();
    }

    /**
     * 中序遍历，放入list中
     * @param root
     * @return
     */
    private void inorderTraversal(TreeNode root) {
        if(root==null){
            return ;
        }

        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);

    }

    /**
     * 指针右移，并返回当前指针处的数字
     * @return
     */
    public int next() {
        index++;
        return list.get(index);
    }

    /**
     * 判断指针右侧是否有数字
     * @return
     */
    public boolean hasNext() {
        return index+1<length;
    }
}

