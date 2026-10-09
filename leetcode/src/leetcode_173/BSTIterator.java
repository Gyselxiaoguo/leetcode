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
    int idx=0;

    public BSTIterator(TreeNode root) {
        inorderTraversal(root);
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
     * 返回当前指针处的数字,指针右移
     * @return
     */
    public int next() {
        int ans=list.get(idx);
        idx++;
        return ans;
    }

    /**
     * 判断当前指针是否有数字
     * @return
     */
    public boolean hasNext() {
        return idx<list.size();
    }
}

